Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        //T:O(n) , S:O(1) - since max values we can store in the set will be 256 chars which is a constant
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int i = 0;
        for (int j=0; j<s.length(); j++) {
            //2
            while(charSet.contains(s.charAt(j))) {
                charSet.remove(s.charAt(i));
                i++;
            }

            //1
            charSet.add(s.charAt(j));
            maxLength = Math.max(maxLength, j-i+1);
            //more test cases: "abb" , "bab", "", " "
        }
        return maxLength;


      

        //brute force: T:O(n^2), S:O(1)
        if (s.length()<=0) {
            return 0;
        }
        int maxLength = 1;
        for (int i=0; i<s.length(); i++) {
            int length = 0;
            Set<Character> set = new HashSet<>();
            for (int j=i; j<s.length(); j++) {
                if(set.contains(s.charAt(j))) {
                    maxLength = Math.max(maxLength, (j-i));
                    break;
                } else {
                    set.add(s.charAt(j));
        to handle a edge case where all the characters in a string are unique
                    length++;
                }
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
