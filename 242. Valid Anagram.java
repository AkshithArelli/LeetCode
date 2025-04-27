Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?


class Solution {
    public boolean isAnagram(String s, String t) {
      //T:O(n) , S:O(n)
        if (s.length() != t.length()) {
            return false;
        }
        // Map<Character,Integer> sFreq = new HashMap<>();
        // for (char c : s.toCharArray()) {
        //     sFreq.put(c , sFreq.getOrDefault(c,0) + 1);
        // }
        // Map<Character,Integer> tFreq = new HashMap<>();
        // for (char c : t.toCharArray()) {
        //     tFreq.put(c, tFreq.getOrDefault(c,0) + 1);
        // }
        //better to use one loop
        Map<Character,Integer> sFreq = new HashMap<>();
        Map<Character,Integer> tFreq = new HashMap<>();
        for (int i=0; i<s.length() ; i++) {
            sFreq.put(s.charAt(i) , sFreq.getOrDefault(s.charAt(i),0) + 1);
            tFreq.put(t.charAt(i) , tFreq.getOrDefault(t.charAt(i),0) + 1);
        }

        //don't use the commented code as here integer object is compared using == sign which not compares the value but reference
        // for (Map.Entry<Character,Integer> e : tFreq.entrySet()) {
        //         if (e.getValue() != sFreq.get(e.getKey())) {
        //             return false;
        //         }
        //     }
        // return true;
        //
        //the correct approach could be:
        // for (Map.Entry<Character,Integer> e : tFreq.entrySet()) {
        //         if (!e.getValue().equals(sFreq.get(e.getKey()))) {
        //             return false;
        //         }
        //     }
        // return true;
        return sFreq.equals(tFreq);
    }
}
