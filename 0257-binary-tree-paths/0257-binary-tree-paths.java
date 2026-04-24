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
    public void preorder(TreeNode root, List<String> list, String ans){
        if(root == null){
            return;
        }
        ans += root.val;
        if(root.left == null && root.right == null){
            list.add(ans);
        }
        preorder(root.left, list, ans+"->");
        preorder(root.right, list, ans+"->");
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        preorder(root, ans, "");
        return ans;
    }
}