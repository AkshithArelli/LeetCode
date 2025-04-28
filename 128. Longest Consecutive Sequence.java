Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109


class Solution {
    public int longestConsecutive(int[] nums) {
        //using hashset for O(n)
        //T:O(n) even though there is a inner loop, 
        //in worst case scenarion [10,20,30] the inner loop does run as there is no num+1 at any given time
        //if there are multiple consecutive sequences, lets say three out of n numbers the inner while loop runs only 3 times
        //therefore. O(n) + O(constant time) = O(n)
        //S: O(n) to store elements
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (Integer num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (Integer num : numSet) {
            //checking if previous number exists for the current num, if exists then it is not the start of the sequence and here we are trying to calculate the sequence
            if (!numSet.contains(num-1)) {
                int currentStreak = 1;
                int currentNum = num;
                while(numSet.contains(currentNum+1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(currentStreak,longestStreak);
            }
        }
        return longestStreak;

        //brute force, using sorting
        //T:O(nlogn), S:O(1)
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 0;
        int current = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] != nums[i-1] +1) {
                longest = Math.max(current,longest);
                current = 0;
            }
            current++;
        }
        return Math.max(current,longest);
    }
}
