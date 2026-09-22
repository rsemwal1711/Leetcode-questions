class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int up = i-1<0 ? Integer.MAX_VALUE : dp[i-1][j];
                int upleft = i-1<0 || j-1<0 ? Integer.MAX_VALUE : dp[i-1][j-1];
                int upright = i-1<0 || j+1 >= n ? Integer.MAX_VALUE : dp[i-1][j+1];
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(upleft, upright));
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            mini = Math.min(mini, dp[n-1][i]);
        }
        return mini;
    }
}