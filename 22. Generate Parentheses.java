Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

Solution:

class Solution {
    public List<String> generateParenthesis(int n) {
        //T:O(2^2n), S:(2n)
        List<String> result = new ArrayList<>();
        generate(n, n, "", result);
        return result;

    }

    private void generate(int open, int close, String current, List<String> result) {
        if (open==0 && close==0) { //if n=2; open-2,close-2
            result.add(current);
            return;
        }
        if (open > 0) { //we can always start open paranthesis if open is > 0 
            generate(open-1,close, current+"(", result);
        }
        if (close > open) { //we can only start closed paranthesis if close<open otherwise
            generate(open, close-1, current+")", result);   //it will be in invalid
        }
    }
}

//https://www.youtube.com/watch?v=NHw8ycom-f8&t=134s (from 9:00)


