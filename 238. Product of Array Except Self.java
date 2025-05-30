Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


class Solution {
    public int[] productExceptSelf(int[] nums) {
        //T: O(n) , S: O(1)
        //refer apna college video
        int[] outPut = new int[nums.length];

        outPut[0] = 1;
        for (int i=1; i<nums.length; i++) {
            outPut[i] = nums[i-1] * outPut[i-1];
        }

        int suffix = 1;
        for (int i=nums.length-2; i>=0; i--) {
            suffix *= nums[i+1];
            outPut[i] *= suffix;
        }

        return outPut;


      

        //T: O(n) , S: O(n)
        int[] outPut = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        for (int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        suffix[nums.length-1] = 1;
        for (int i=nums.length-2 ; i>=0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i=0 ; i<nums.length; i++) {
            outPut[i] = prefix[i] * suffix[i];
        }

        return outPut;


        //bruteforce
        //but this doesn't get submitted
        int[] outPut = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            outPut[i] = 1;
            for (int j=0; j<nums.length; j++) {
                if (i != j) {
                    outPut[i] *= nums[j];
                }
            }
        }
        return outPut;
    }
}
