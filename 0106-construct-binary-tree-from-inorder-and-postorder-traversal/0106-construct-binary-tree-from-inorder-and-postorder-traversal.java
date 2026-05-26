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
    public TreeNode build(int[] in, int instart, int inend, int[] post, int poststart, int postend, Map<Integer, Integer> mpp){
        if(instart > inend || poststart > postend) return null;
        TreeNode root = new TreeNode(post[postend]);
        int inroot = mpp.get(root.val);
        int numsleft = inroot - instart;
        root.left = build(in, instart, inroot-1, post, poststart, poststart+numsleft-1, mpp);
        root.right = build(in, inroot+1, inend, post, poststart+numsleft, postend-1, mpp);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++){
            mpp.put(inorder[i], i);
        }
        return build(inorder, 0, n-1, postorder, 0, n-1, mpp);
    }
}