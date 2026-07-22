class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0}); // diff, row, col
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int diff = p[0];
            int row = p[1];
            int col = p[2];
            if(row == n-1 && col == m-1) return diff;
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newDiff = Math.max(diff, Math.abs(heights[nrow][ncol] - heights[row][col]));
                    if(newDiff < dist[nrow][ncol]){
                        dist[nrow][ncol] = newDiff;
                        pq.add(new int[]{newDiff, nrow, ncol});
                    }
                }
            }
        }
        return 0;
    }
}