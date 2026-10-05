class Solution {
    public int func(int i, int root, int remaining, int[][] dp){
        if(remaining == 0){
            return 0;
        }
        if(i > root || remaining < 0) return (int) 1e9;
        if(dp[i][remaining] != -1) return dp[i][remaining];
        int takeSame = 1 + func(i, root, remaining - i*i, dp);
        int takeNext = func(i+1, root, remaining, dp);
        return dp[i][remaining] = Math.min(takeSame, takeNext);
    }
    public int numSquares(int n) {
        int ans = Integer.MAX_VALUE;
        int root = (int) Math.sqrt(n) + 1;
        int[][] dp = new int[root + 1][n + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        for(int i=1;i<=root;i++){
            ans = Math.min(ans, func(i, root, n, dp));
        }
        return ans;
    }
}