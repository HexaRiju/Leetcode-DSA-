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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        int bool = 1;
        if(root == null)
            return list;
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            int[] l = new int[s];
            while(s > 0){
                TreeNode t = q.poll();
                if(bool == 1)
                    l[l.length - s] = t.val;
                else
                    l[s - 1] = t.val;
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
                s--;
            }
            List lr = new ArrayList<>();
            for(int i : l)
                lr.add(i);
            list.add(lr);
            bool = 1 - bool;
        }
        return list;
    }
}