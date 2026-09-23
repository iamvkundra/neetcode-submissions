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
        int height;
        boolean isBalanced;
        public Node(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return solve(root).isBalanced;
    }

    private Node solve(TreeNode root) {
        if (root == null) {
            return new Node(0, true);
        }

        Node left = solve(root.left);
        Node right = solve(root.right);

        if (Math.abs(left.height - right.height) > 1) {
            return new Node(0, false);
        }

        return new Node(1 + Math.max(left.height, right.height), left.isBalanced && right.isBalanced);
    }
}
