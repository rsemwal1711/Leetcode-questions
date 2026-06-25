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
class NodeValue{
    int minvalue;
    int maxvalue;
    int maxsize;
    NodeValue(int minvalue, int maxvalue, int maxsize){
        this.minvalue = minvalue;
        this.maxvalue = maxvalue;
        this.maxsize = maxsize;
    }
}
class Solution {
    int ans = 0;
    public NodeValue dfs(TreeNode root){
        if(root == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        NodeValue left = dfs(root.left);
        NodeValue right = dfs(root.right);
        if(left.maxvalue < root.val && root.val < right.minvalue){
            int curr = left.maxsize+right.maxsize+root.val;
            ans = Math.max(curr, ans);
            return new NodeValue(Math.min(root.val, left.minvalue), Math.max(root.val, right.maxvalue), curr);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxsize, right.maxsize));
    }
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
}