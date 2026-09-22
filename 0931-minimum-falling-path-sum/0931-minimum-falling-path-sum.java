class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];
        
        for(int i=0;i<n;i++){
            prev[i] = matrix[0][i];
        }
        for(int i=1;i<n;i++){
            int[] curr = new int[n];
            for(int j=n-1;j>=0;j--){
                int up = i-1<0 ? Integer.MAX_VALUE : prev[j];
                int upleft = i-1<0 || j-1<0 ? Integer.MAX_VALUE : prev[j-1];
                int upright = i-1<0 || j+1 >= n ? Integer.MAX_VALUE : prev[j+1];
                curr[j] = matrix[i][j] + Math.min(up, Math.min(upleft, upright));
            }
            prev = curr;
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            mini = Math.min(mini, prev[i]);
        }
        return mini;
    }
}