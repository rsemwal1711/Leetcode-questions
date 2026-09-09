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
    public int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }
    public void print(TreeNode root, String[][] arr, int i, int j, int rows, int cols){
        if(root == null || i < 0 || j < 0 || i >= rows || j >= cols) return;
        arr[i][j] = root.val + "";
        print(root.left, arr, i+1, j - (int) Math.pow(2, rows-i-2), rows, cols);
        print(root.right, arr, i+1, j + (int) Math.pow(2, rows-i-2), rows, cols);
    }
    public List<List<String>> printTree(TreeNode root) {
        int rows = height(root);
        int cols = (int) Math.pow(2, rows) - 1;
        String[][] arr = new String[rows][cols];        
        print(root, arr, 0, (cols-1)/2, rows, cols);

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<rows;i++){
            List<String> temp = new ArrayList<>();
            for(int j=0;j<cols;j++){
                if(arr[i][j] == null) temp.add("");
                else temp.add(arr[i][j]);
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}