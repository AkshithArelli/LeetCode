Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.


class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) { 
        //use left <= right and not left < right
        // to include the case where if the required element is in first or last position
        //eg: [5] target = 5 , [2,4,6,8,10] target = 10
            //int middle = (left + right)/2; see below why it should not be used 
            int middle = left + (right - left)/2;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else{
                left = middle + 1;
            }
        }
        return -1;

        //int middle = (left + right)/2; this causes overflow as integers have fixed range
        //int in Java is from -2,147,483,648 (-231) to 2,147,483,647 (231 - 1)
        //eg: if int left = 2000000000; int right = 2000000030;
        //then int middle = (left + right)/2; this overflows since, left+right = 4000000030
        //so if int middle = left + (right - left)/2; 
        //the calculations made here will be in range
    }
}
