Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.



class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //T:O(n),S:O(1)
        //s1 cannot be greater than s2 
        //because if s1 is longer, no permutation of s1 can exist in s2 
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        //we use s1 length as window size and store frequency, compare and slide it over
        for (int i=0; i<s1.length(); i++) {
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }

        for (int i=0; i<s2.length()-s1.length(); i++) {
            //window of size s1.length() is slid one character at a time
            if (matches(s1Count, s2Count)) {
                return true;
            }
            //add the new character coming in right
            s2Count[s2.charAt(i+s1.length())-'a']++;
            //remove the character going out(left)
            s2Count[s2.charAt(i)-'a']--;
        }
        //this checks last possible window, which is missed by the loop
        return matches(s1Count, s2Count);
    }

    private boolean matches(int[] freq1, int[] freq2) {
        for (int i=0; i<26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
