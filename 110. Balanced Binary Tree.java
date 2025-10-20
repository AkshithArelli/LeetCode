Given a binary tree, determine if it is height-balanced.

 

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:
Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

  Solution:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        /*
        We want to check if a binary tree is balanced:
        For every node, |leftHeight - rightHeight| ≤ 1

        Every node reports either its height (if okay) or -1 (if unbalanced).
        As soon as a -1 appears, it spreads upward like a red alert.
        No one calculates further heights when the alert is on.”
        */
        //T:O(n), S:O(h)
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode node) {
        if (node == null) return 0;

        int left = dfsHeight(node.left);
        int right = dfsHeight(node.right);

        //if left or right subtree is already unbalanced or current node is unbalanced return -1
        //so, the unbalanced will always return -1 and sends back -1 to top, further check is prevented
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;

        //return height of the current subtree
        return 1 + Math.max(left, right);
    }
}
