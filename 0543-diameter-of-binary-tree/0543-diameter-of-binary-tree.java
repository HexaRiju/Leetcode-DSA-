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
    int res = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return res;
    }
    public int find(TreeNode root) {
        if (root == null)
            return 0;
        int leftVal = find(root.left);
        int rightVal = find(root.right);
        int sum = leftVal + rightVal;
        res = Math.max(sum, res);
        return 1 + Math.max(leftVal, rightVal);
    }
}