You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45


class Solution {
    public int climbStairs(int n) {
        //for 1 step: 1way
        //for 0 step: 1way to be on ground
        //0 1  2 3 4 5 6 ...
        //1 1  2 3 5 8 13
        //     n = (n-1) + (n-2) //just like fibonacci

        //dp array
        //values:  1 1 2 3 5 8 13
        //indices: 0 1 2 3 4 5 6
        //optimised DP in space
        //T:O(n) , S:O(1)
        int previousOneNumber = 1;
        int previousTwoNumber  = 1;
        int currentNumber = 1;
        for (int i=2; i<=n; i++) {
            currentNumber = previousOneNumber + previousTwoNumber;
            previousOneNumber = previousTwoNumber;
            previousTwoNumber = currentNumber;
        }
        return currentNumber;


      
        //DP
        //T:O(n) , S: O(n)
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp [i-2];
        }
        return dp[n];

        //recursion , but for the large numbers this might throw time limit exeeded
        T: O(2n) since each step is split into two possibilities
        if (n==0 || n==1) {
            return 1;
        } 

        return climbStairs(n-1) + climbStairs(n-2);
    }
} 
