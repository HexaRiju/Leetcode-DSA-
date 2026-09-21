/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode node = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < q.val)
            ans(root, p, q);
        else
            ans(root, q, p);
        return node;
    }
    public void ans(TreeNode root, TreeNode p, TreeNode q){
        if(root.val == p.val || root.val == q.val){
            node = root;
            return;
        }
        else if(root.val < p.val && root.val < q.val)
            ans(root.right, p, q);
        else if(root.val > p.val && root.val > q.val)
            ans(root.left, p, q);
        else{
            node = root;
            return;
        }
    }
}