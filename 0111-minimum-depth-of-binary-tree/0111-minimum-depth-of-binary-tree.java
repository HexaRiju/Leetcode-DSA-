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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return find(root, 0);
    }
    public int find(TreeNode root, int count){
        if(root == null)
            return Integer.MAX_VALUE;
        count++;
        if(root.left == null && root.right == null)
            return count;
        else
            return Math.min(find(root.left, count), find(root.right, count));
    }
}