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
    class Node {
        TreeNode node;
        int height;
        public Node(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return max-1;
    }

    private Node solve(TreeNode root) {
        if (root == null) {
            return new Node(root, 0);
        }

        Node left = solve(root.left);
        Node right = solve(root.right);
        int leftHeight = left == null ? 0 : left.height;
        int rightHeight = right == null ? 0 : right.height;
        max = Math.max(max, 1 + leftHeight + rightHeight);

        return new Node(root, 1+ Math.max(leftHeight, rightHeight));
    }
}
