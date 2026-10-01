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
    TreeNode wrong_1_first = null, wrong_1_second = null, wrong_2_first = null, wrong_2_second = null, prev = null;
    int wrong = 0;
    public void recoverTree(TreeNode root) {
        swap(root);
        if(wrong_2_first == null){
            int temp = wrong_1_first.val;
            wrong_1_first.val = wrong_1_second.val;
            wrong_1_second.val = temp;
        }
        else{
            int temp = wrong_1_first.val;
            wrong_1_first.val = wrong_2_second.val;
            wrong_2_second.val = temp;
        }
    }
    public void swap(TreeNode root){
        if(root == null)
            return;
        swap(root.left);
        if(prev == null)
            prev = root;
        else{
            if(prev.val >= root.val && wrong == 0){
                wrong_1_first = prev;
                wrong_1_second = root;
                wrong++;
            }
            else if(prev.val >= root.val){
                wrong_2_first = prev;
                wrong_2_second = root;
            }
            prev = root;
        }
        swap(root.right);
        return;
    }
}