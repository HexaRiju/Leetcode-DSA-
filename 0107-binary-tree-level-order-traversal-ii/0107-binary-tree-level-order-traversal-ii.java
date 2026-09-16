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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null)
            return res;
        q.add(root);
        while (!q.isEmpty()) {
            int s = q.size();
            List<Integer> temp = new ArrayList<>();
            while (s > 0) {
                TreeNode t = q.poll();
                temp.add(t.val);
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
                s--;
            }
            res.add(temp);
        }
        int i = 0, j = res.size() - 1;
        while( i < j){
            List temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
            i++;
            j--;
        }
        return res;
    }
}