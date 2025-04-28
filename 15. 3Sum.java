Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105



  class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //T:O(n^2) , S:O(1) No additional space is used other than the output list.
        //the idea her is first sort the array
        //then take out the first most ele in array and use two pointer approach to the remaining array
        //eg: sorted array = [-1, -1, 0, 1, 2]
        //take out -1 and left with [-1, 0, 1, 2]
        //now using two pointer approach add left and right numbers to picked out number if they matched target add them to the list, do this for each number
        //next iteration: -1,  [0, 1, 2]

        if (nums == null || nums.length < 3) return new ArrayList<>();

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        //i<nums.length-2 because we need triplets when i reaches end we will be having 2 numbers left so we can return them if they are triplets
        for (int i=0; i<nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
