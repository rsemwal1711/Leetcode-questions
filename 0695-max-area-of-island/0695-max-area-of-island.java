class Solution {
    public int maxArea(int i, int j, int[][] grid, int[][] vis, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        int count = 1;
        q.add(new int[]{i, j});
        vis[i][j] = 1;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int[] it = q.poll();
            int row = it[0];
            int col = it[1];
            for(int z=0;z<4;z++){
                int nrow = row + delrow[z];
                int ncol = col + delcol[z];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && 
                grid[nrow][ncol] == 1){
                    count++;
                    vis[nrow][ncol] = 1;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    int a = maxArea(i, j, grid, vis, n, m);
                    ans = Math.max(ans, a);
                }
            }
        }
        return ans;
    }
}