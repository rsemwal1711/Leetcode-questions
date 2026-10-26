class Solution {
    public long func(int row, int col, boolean[][] vis, int[] delrow, int[] delcol, int[][] grid){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length) return 0;
        if(vis[row][col] || grid[row][col] == 0) return 0;
        vis[row][col] = true;
        long sum = grid[row][col];
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            sum += func(nrow, ncol, vis, delrow, delcol, grid);
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] != 0 && !vis[i][j]){
                    long sum = func(i, j, vis, delrow, delcol, grid);
                    if(sum % k == 0) count++;
                }
            }
        }
        return count;
    }
}