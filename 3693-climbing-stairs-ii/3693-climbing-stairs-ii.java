class Solution {
    public int memoization(int i, int n, int[] costs, int[] dp){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int mini = Integer.MAX_VALUE;
        for(int j=i+1;j<=Math.min(i+3, n);j++){
            int cost = costs[j-1] + (j-i) * (j-i) + memoization(j, n, costs, dp);
            mini = Math.min(cost, mini);
        }
        return dp[i] = mini;
    }
    public int climbStairs(int n, int[] costs){
        // Memoization : 
        /* int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return memoization(0, n, costs, dp); */

        // Tabulation : 
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int mini = Integer.MAX_VALUE;
            for(int j=i+1;j<=Math.min(i+3, n);j++){
                int cost = costs[j-1] + (j-i) * (j-i) + dp[j];
                mini = Math.min(cost, mini);
            }
            dp[i] = mini;
        }
        return dp[0];
    }
}