Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.



  class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //using frequency
        //T:O(nk) , k is to prepare frequencyKeyString, n to iterate over n words
        //S:O(nk)
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : strs) {
            int[] charCount = new int[26];
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                charCount[c - 'a']++;
            }
            StringBuilder frequencyKeyStringBuilder = new StringBuilder();
            char c = 'a';
            for (int i : charCount) {
                frequencyKeyStringBuilder.append(c);
                frequencyKeyStringBuilder.append(i);
                c++;
            }
            String frequencyKeyString = frequencyKeyStringBuilder.toString();
            if(!anagramMap.containsKey(frequencyKeyString)) {
                anagramMap.put(frequencyKeyString, new ArrayList<>());
            }
            anagramMap.get(frequencyKeyString).add(word);
        }
        return new ArrayList<>(anagramMap.values());


        //using sort
        //T: O(nlogk) , n is number of strings, k is max length of a string
        //S: O(nk)
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            if(!anagramMap.containsKey(sortedWord)) {
                anagramMap.put(sortedWord, new ArrayList<>());
            }
            anagramMap.get(sortedWord).add(word);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
