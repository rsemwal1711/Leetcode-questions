class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 && j == 0){
                    dp[0][0] = grid[0][0];
                    continue;
                }
                int down = grid[i][j];
                if(i > 0) down += dp[i-1][j];
                else down += (int) 1e9;
                int right = grid[i][j];
                if(j > 0) right += dp[i][j-1];
                else right += (int) 1e9;
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[n-1][m-1];
    }
}