/**
 * (c) 2021 Lingxi Li.
 *
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return helper(root, 0, low, high);
    }

    // @param dir: 0 = def, 1 = left, 2 = right.
    private TreeNode helper(TreeNode curr, int dir, int low, int high) {
        if (curr == null) {
            return null;
        }

        // Over the range limit, traverse the next level to erase the current node.
        if (curr.val < low) {
            return helper(curr.right, 2, low, high);
        }
        if (curr.val > high) {
            return helper(curr.left, 1, low, high);
        }

        // Not over the range limit, keep current node and go to next level.
        curr.left = helper(curr.left, 1, low, high);
        curr.right = helper(curr.right, 2, low, high);
        return curr;
    }
}
