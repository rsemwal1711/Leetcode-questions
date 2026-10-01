class Solution {
    public int memoization(int i, int prev_i, int n, int[] nums, int[][] dp){
        if(i == n) return 0;
        if(dp[i][prev_i+1] != -1) return dp[i][prev_i+1];
        int notTake = 0 + memoization(i+1, prev_i, n, nums, dp);
        int take = 0;
        if(prev_i == -1 || nums[i] > nums[prev_i]){
            take = 1 + memoization(i+1, i, n, nums, dp);
        }
        return dp[i][prev_i+1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return memoization(0, -1, n, nums, dp);
    }
}