class Solution {
    public int memoization(int i, int n, int[] arr, int k, int[] dp){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int j=i;j<Math.min(i+k, n);j++){
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (len * maxi) + memoization(j+1, n, arr, k, dp);
            ans = Math.max(ans, sum);
        }
        return dp[i] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // Memoization :
        /* 
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            return memoization(0, n, arr, k, dp); 
        */

        // Tabulation :
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int maxi = Integer.MIN_VALUE;
            int ans = Integer.MIN_VALUE;
            int len = 0;
            for(int j=i;j<Math.min(i+k, n);j++){
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = (len * maxi) + dp[j+1];
                ans = Math.max(ans, sum);
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}