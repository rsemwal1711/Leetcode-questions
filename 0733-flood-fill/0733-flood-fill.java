class Solution {
    public void dfs(int[][] image, int sr, int sc, int color, int inicolor, int[][] ans, int[] delrow, int[] delcol, int n, int m){
        ans[sr][sc] = color;
        for(int i=0;i<4;i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == inicolor && ans[nrow][ncol] != color){
                dfs(image, nrow, ncol, color, inicolor, ans, delrow, delcol, n, m);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int inicolor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        dfs(image, sr, sc, color, inicolor, ans, delrow, delcol, n, m);
        return ans;
    }
}