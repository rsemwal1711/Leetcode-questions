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
    public void paths(TreeNode root, int targetSum, int sum, List<Integer> temp, List<List<Integer>> ans){
        if(root == null){
            return;
        }

        temp.add(root.val);
        sum += root.val;

        if(root.left == null && root.right == null && sum == targetSum){
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        paths(root.left, targetSum, sum, temp, ans);
        paths(root.right, targetSum, sum, temp, ans);

        sum -= root.val;
        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        paths(root, targetSum, 0, temp, ans);
        return ans;
    }
}