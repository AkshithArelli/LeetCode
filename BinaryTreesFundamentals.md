~~~java
package DSA;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val) {
        this.val = val;
    }
}

public class BinaryTreeTraversals {

    //dfs
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    
    //dfs
    public static void inorder(TreeNode root) {
        if (root ==null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    //dfs
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    //bfs
    public static void levelordertraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static int countNumberOfNodes(TreeNode root) {
        if (root == null) return 0;
        int leftNode = countNumberOfNodes(root.left);
        int rightNode = countNumberOfNodes(root.right);
        return leftNode + rightNode + 1;
    }

    public static int sumOfNodes(TreeNode root) {
        if (root == null) return 0;
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.val;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        int maxHeight = Math.max(leftHeight,rightHeight) + 1;

        return maxHeight;
    }

    public static void main(String[] args) {
        // Building the sample tree:
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("preorder traversal");
        preorder(root);
        System.out.println("inorder traversal");
        inorder(root);
        System.out.println("postorder traversal");
        postorder(root);
        System.out.println("levelorder traversl");
        levelordertraversal(root);
        System.out.println("Total number of nodes:");
        System.out.println(countNumberOfNodes(root));
        System.out.println("Sum of nodes:");
        System.out.println(sumOfNodes(root));
        System.out.println("max height/depth:");
        System.out.println(maxDepth(root));
    }
}
~~~
