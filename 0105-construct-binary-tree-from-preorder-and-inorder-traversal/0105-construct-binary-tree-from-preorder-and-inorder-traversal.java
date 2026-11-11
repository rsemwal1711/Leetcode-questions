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
    int pre;

    public TreeNode func(int[] preorder, int[] inorder, int left, int right){
        if(left > right) return null;
        int rootVal = preorder[pre++];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = func(preorder, inorder, left, index-1);
        root.right = func(preorder, inorder, index+1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = 0;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return func(preorder, inorder, 0, preorder.length-1);
    }
}