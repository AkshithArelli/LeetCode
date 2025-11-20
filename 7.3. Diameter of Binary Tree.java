Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
  
Example 2:
Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100

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
    //this variable is part of our solution, not predefined
    private int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        //Intuition
        //The diameter of a binary tree =
        //the longest path between any two nodes (can go through or not through the root).
        //That path:
	    //•	Must pass through some node N that acts as the “highest common ancestor” of those two farthest nodes.
	    //•	And that path length = height of left subtree + height of right subtree (at that node).
        //To compute the diameter, you need height of left and right subtrees.
        //T:O(n) -> we have to go through each node once
        //s:O(h) -> as we are doing recursion, the stack 
        //At the deepest point, recursion stack depth = height of the tree.
        //So O(h) (O(log n) for balanced tree, O(n) for skewed).
        
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, (leftHeight+rightHeight));
        return Math.max(leftHeight,rightHeight)+1;
    }
}
