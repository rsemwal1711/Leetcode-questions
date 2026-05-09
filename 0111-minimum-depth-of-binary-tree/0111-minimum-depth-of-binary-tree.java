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
    int miniD = Integer.MAX_VALUE;
    public int check(TreeNode root){
        if(root == null) return 0;
        int left = check(root.left);
        int right = check(root.right);
        if(left == 0) return 1+right;
        if(right == 0) return 1+left;
        return 1 + Math.min(left, right);
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return check(root);
    }
}