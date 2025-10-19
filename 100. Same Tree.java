Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

  Constraints:

The number of nodes in both trees is in the range [0, 100].
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //approach 1
        //recursive approach
        //T:O(n) - we visit each node once
        //S:O(h) - recursion stack (height of tree)
        //case1: both null then return true
        if (p == null && q == null) return true;
        //case2: one null then return false
        if (p == null || q == null) return false;
        //case3: values differ then return false;
        if (p.val != q.val) return false;
        //recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        //approcah 2
        //using queue by BFS/level order traversal
        //T:O(n) , S:O(n)
        //eg: 1
        /*
        p:       1
                / \
               2   3

        q:       1
                / \
               2   3
        order = [1,2,3,null,null] , [1,2,3,null,null]

        eg: 2
        p:      1
               / 
              2   

        q:      1
                 \
                  2
        order = [1,2,null] [1,null,2]
        */

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            //if both are null we can exit as we reached end
            if (first == null && second == null) {
                continue;
            } else if (first == null || second == null || first.val != second.val) {
                return false;
            }

            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        }
        return true;
    }
}
