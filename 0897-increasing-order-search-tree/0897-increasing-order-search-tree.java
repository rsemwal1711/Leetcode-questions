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
    TreeNode prev = null;
    TreeNode head = null;
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev == null){
            head = root;
        }
        if(prev != null){
            prev.right = root;
        }
        root.left = null;
        prev = root;
        inorder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return head;
    }
}