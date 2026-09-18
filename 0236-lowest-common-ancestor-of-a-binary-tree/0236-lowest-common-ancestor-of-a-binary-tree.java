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
    TreeNode ar = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = ans(root, p, q);
        //System.out.print(x);
        return ar;
    }
    public int ans(TreeNode root, TreeNode p,TreeNode q){
        if(root == null)
            return 0;
        int L = ans(root.left, p, q);
        int R = ans(root.right, p, q);
        int self = 0;
        if(root == p || root == q)
            self = 1;
        int total = L + R + self;
        if(total == 2 && ar == null)
            ar = root;
        return total;
    }
}