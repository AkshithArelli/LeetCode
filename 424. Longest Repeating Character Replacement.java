You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length



class Solution {
    public int characterReplacement(String s, int k) {
        //T:O(n) , S:O(1)
        int freq[] = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right=0; right<s.length(); right++) {
            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq , freq[s.charAt(right) - 'A']);
            int windowSize = right - left + 1;

            //windowSize - maxFreq gives us elements left over to replace and if they are more than k,
            //we cannot replace extra so we need max of k elements to replace. 
            //That's why we are move left most element and in the iteration the window moves toward right
            //and also we are reducing that element freq by  1 as it is no longer in the window
            if (windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            windowSize = right - left + 1;
            maxWindow = Math.max(maxWindow, windowSize);
        }
        return maxWindow;
    }
}
