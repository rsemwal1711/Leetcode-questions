class Solution {
    int mod = (int) 1e9+7;
    public int func(int i, int n, int[] arr, int parity, int[][] dp){
        if(i == n) return 0;
        if(dp[i][parity] != -1) return dp[i][parity];
        int oldParity = parity;
        parity = (parity + arr[i]) % 2 == 1 ? 1 : 0;
        int count = parity == 1 ? 1 : 0;
        return dp[i][oldParity] = (int) (count + func(i+1, n, arr, parity, dp)) % mod;
    }
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            count = (count + func(i, n, arr, 0, dp)) % mod;
        }
        return count;
    }
}