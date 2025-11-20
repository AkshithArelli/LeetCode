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

Awesome! Let’s walk through both the tree visualization and a dry run of the Java version of generateParenthesis(n) when n = 2.


---

🌳 Tree Visualization for n = 2 (i.e., 2 open and 2 close)

We start with:

open = 2, close = 2, curr = ""

We'll use the following logic:

If open > 0 → add '('

If close > open → add ')'



---

📘 Tree

"" (2,2)
                         /        \
                "(" (1,2)          -- [open-1]
                   /     \     
        "((" (0,2)        "()" (1,1)
          |                |       \
       "(()" (0,1)       "(()"     "()(" (0,1)
          |                |         |
       "(())" (0,0)     Not valid   "()()" (0,0)


---

✅ Dry Run:

We start with generate(2, 2, "")


---

Call 1: (2,2,"")
→ open > 0 → Call (1,2,"(")


---

Call 2: (1,2,"(")
→ open > 0 → Call (0,2,"((")


---

Call 3: (0,2,"((")
→ close > open → Call (0,1,"(()")


---

Call 4: (0,1,"(()")
→ close > open → Call (0,0,"(())") ✅ add to result


---

Backtrack to Call 2: (1,2,"(")
→ close > open → Call (1,1,"()")


---

Call 5: (1,1,"()")
→ open > 0 → Call (0,1,"()(")


---

Call 6: (0,1,"()(")
→ close > open → Call (0,0,"()()") ✅ add to result


---

✅ Final Result:

["(())", "()()"]


---

💡 Notes:

Invalid paths like ")(" or "(()))" are never generated because we never allow close < open.

Tree shows all valid recursive paths, pruned automatically by the condition open < close.


 ----

Time complexity:

We can place 2n characters (n '(' and n ')').

For each character position, there are at most 2 choices — '(' or ')'.

So naive upper bound = 2^2n combinations.


But we don't generate all combinations — only the valid ones.


Space complexity:

Each valid string has 2n characters → the depth of recursion is at most 2n.

So, stack space used = O(2n) in the worst case.
