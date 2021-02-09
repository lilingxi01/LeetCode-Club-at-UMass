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
    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }
    
    private int helper(TreeNode node, int before) {
        if (node == null) {
            return 0;
        }
        int right = helper(node.right, before);
        int left = helper(node.left, before + right + node.val);
        int nodeVal = node.val;
        node.val += before + right;
        return left + right + nodeVal;
    }
}
