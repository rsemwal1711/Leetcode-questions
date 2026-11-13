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
    public int func(TreeNode root, StringBuilder a){
        if(root == null){
            return 0;
        }
        int sum = 0;
        a.append(root.val);
        if(root.left == null && root.right == null){
            sum = a.length() == 0 ? 0 : Integer.parseInt(a.toString());
        }
        else{
            sum += func(root.left, a) + func(root.right, a);
        }
        a.deleteCharAt(a.length() - 1);
        return sum;
    }
    public int sumNumbers(TreeNode root) {
        return func(root, new StringBuilder());
    }
}