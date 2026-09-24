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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return res;
        balanced(root);
        return res;
    }
    public int balanced(TreeNode root) {
        if (root == null)
            return 0;
        int left = balanced(root.left);
        int right = balanced(root.right);
        res = res && (Math.abs(left - right) <= 1);
        return 1 + Math.max(left, right);
    }
}