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
    TreeNode node = null;
    public TreeNode searchBST(TreeNode root, int val) {
        find(root, val);
        return node;
    }
    public void find(TreeNode n, int val){
        if(n == null)
            return;
        else if(n. val == val){
            node = n;
            return;
        }
        else if(n.val < val)
            find(n.right, val);
        else
            find(n.left, val);
        return;
    }
}