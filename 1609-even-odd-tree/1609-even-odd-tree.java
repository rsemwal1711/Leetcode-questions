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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int prev1 = Integer.MIN_VALUE;
            int prev2 = Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(level % 2 == 0){
                    if(node.val % 2 == 0 || node.val <= prev1) return false;
                    else{
                        prev1 = node.val;
                    }
                }
                else{
                    if(node.val % 2 == 1 || node.val >= prev2) return false;
                    else{
                        prev2 = node.val;
                    }
                }

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            level++;
        }
        return true;
    }
}