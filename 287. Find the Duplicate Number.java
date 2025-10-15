Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.


  Solution:

class Solution {
    public int findDuplicate(int[] nums) {
        //Note: we can solve this problem in various following ways
        //1. comparing each val with the rest of values - T:O(n^2)
        //2. sorting the nums and comparing the curr val with prev - T:O(nlogn)
        //3. using hashset - T:O(n), but we also need S:O(n)
        //4. following approach: here we convert the array to LinkedList cycle problem
        // and detect the duplicate value in O(n) time and O(1) space

        //	•	Phase 1: They meet somewhere in the cycle (not necessarily at the start).
	    //  •	Phase 2: We move one pointer to the start and go step-by-step → 
        //      they meet at the start of the cycle, i.e., the duplicate number.

        /*
        Think of a circular running track:
	    •	slow and fast start at the gate.
	    •	They meet somewhere on the track (Phase 1).
	    •	You reset slow back to the gate (start), and now both move 1 step at a time.
	    •	They’ll meet again at the gate — the start of the cycle (Phase 2).

            So Phase 1 (the “meeting” step):
        •	Moves two pointers at different speeds,
        •	Guarantees they’ll meet inside the cycle,
        •	Now we have a confirmed position inside the cycle to start from in Phase 2.

            Then Phase 2:
        •	Moves one pointer back to start (index 0),
        •	Moves both at equal pace → they’ll meet exactly at the entry point, i.e., the duplicate.


            Floyd’s proof depends on:
	    •	Having one pointer at the intersection point inside the cycle,
	    •	And the other at the start.

        */

        //lets use this array as LL
        //Each index represents a node, and nums[i] is the next pointer (like next = nums[i]).

        //phase1: detect intersection point in cycle
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //phase2: find entry point of cycle
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
