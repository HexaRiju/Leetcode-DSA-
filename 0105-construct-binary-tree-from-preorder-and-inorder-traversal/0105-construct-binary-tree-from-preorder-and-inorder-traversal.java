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
    Map<Integer, Integer> map = new HashMap<>();
    int id = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int low = 0, high = inorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return create(preorder, low, high);
    }
    public TreeNode create(int[]preorder, int low, int high){
        if(low > high)
            return null;
        TreeNode node = new TreeNode();
        node.val = preorder[id];
        int in = map.get(preorder[id]);
        id++;
        node.left = create(preorder, low, in - 1);
        node.right = create(preorder, in + 1, high);
        return node;
    }
}