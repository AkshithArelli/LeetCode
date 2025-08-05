Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.


Solution:

  class Solution {
    public int findMin(int[] nums) {
        //T:O(logn), S:O(1)
        int left = 0;
        int right = nums.length-1;
        ////[5,7,8,12,15,20,-7,-4,0,2] ; [5,7,8,12,15] + [20,-7,-4,0,2]
        //as the array is rotated, when do it into halves one part will be sorted
        //the other will be not in sorted order(entire ele) and this part will be having the minValue
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[right]) {
                //[5,7,8,12,15,20,-7,-4,0,2] , midVal = 15
                //this means the left part is sorted so, need to check in the right part
                left = mid+1;
            } else {
                //the other way is right part is sorted so, need to check in the left part 
                //we keep right as mid because right (nums[mid] <= nums[right])
                //ie mid ele could be the least value
                right = mid;
            }
            //this will continue till left is at that least value (or left and right is at least value 
            //or left and right and mid are at least values, even then the condition fails and loop exit)
        }
        return nums[left];
    } 
}

        //cheatSheet:
        //want minValue: (low<high) ; high=mid; low=mid+1
        //want maxValue: (low<=high) ; low=mid+1; high=mid-1
