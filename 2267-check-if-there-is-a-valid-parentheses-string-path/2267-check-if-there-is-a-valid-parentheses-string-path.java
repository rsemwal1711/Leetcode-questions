class Solution {
    public boolean func(int i, int j, int k, int n, int m, char[][] grid, int[][][] dp){
        if(i > n-1 || j > m-1) return false;
        if(grid[i][j] == '(') k++;
        else if(grid[i][j] == ')') k--;
        if(k < 0) return false;
        if(i == n-1 && j == m-1) return k == 0;
        if(dp[i][j][k] != -1) return dp[i][j][k] == 1;
        boolean down = func(i+1, j, k, n, m, grid, dp);
        boolean right = func(i, j+1, k, n, m, grid, dp);
        dp[i][j][k] = (down || right) == true ? 1 : 0;
        return down || right;
    }
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == ')' || grid[n-1][m-1] == '(') return false;
        int[][][] dp = new int[n][m][n+m];
        for(int[][] aa : dp){
            for(int[] a : aa) Arrays.fill(a, -1);
        }
        return func(0, 0, 0, n, m, grid, dp);
    }
}