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
       /*
        sliding window + character frequency approach.
        1.	Count frequency of all chars in s1.
        2.	Move a window of length = s1.length() across s2.
        3.	If the frequency of chars in the current window == frequency in s1, return true.
        4.	Otherwise, slide the window forward by removing the left char and adding the new right char.
        */
        //T:O(n),S:O(1)
        //s1 cannot be greater than s2 
        //because if s1 is longer, no permutation of s1 can exist in s2 

        if (s1.length() > s2.length())
            return false;

        int[] s1Freq = new int[26];
        int[] window = new int[26];

        // Step 1: fill s1 frequency
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;

            // Maintain window size equal to s1 length
            if ((right - left + 1) > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            // Compare both frequency arrays
            if (Arrays.equals(s1Freq, window)) {
                return true;
            }
        }
        return false;




     
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
