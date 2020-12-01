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
    public int maxDepth(TreeNode root) {
        return helper(root);
    }
    
    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int depth = 0;
        if (node.left != null)
            depth = Math.max(depth, helper(node.left));
        if (node.right != null)
            depth = Math.max(depth, helper(node.right));
        return depth + 1;
    }
}
