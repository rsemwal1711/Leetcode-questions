class Solution {
    public int memoization(int i, int j, List<Integer> cuts, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = cuts.get(j+1) - cuts.get(i-1) + memoization(i, ind-1, cuts, dp) + memoization(ind+1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] arr) {
        int c = arr.length;
        List<Integer> cuts = new ArrayList<>();
        for(int i=0;i<c;i++){
            cuts.add(arr[i]);
        }
        cuts.add(n);
        cuts.add(0, 0);
        Collections.sort(cuts);
        /*
        // Memoization
        int[][] dp = new int[c+1][c+1];
        for(int[] rows : dp) Arrays.fill(rows, -1);
        return memoization(1, c, cuts, dp);
        */

        // Tabulation : 

        int[][] dp = new int[c+2][c+1];
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                int mini = Integer.MAX_VALUE;
                if(i > j) continue;
                for(int ind=i;ind<=j;ind++){
                    int cost = cuts.get(j+1) - cuts.get(i-1) + dp[i][ind-1] + dp[ind+1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }
}