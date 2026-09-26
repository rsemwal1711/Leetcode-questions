class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];
        for(int i=n-1;i>=0;i--){
            for(int transaction=0;transaction<2*k;transaction++){
                if(transaction % 2 == 0){
                    dp[i][transaction] = Math.max(
                        -prices[i] + dp[i+1][transaction+1],
                        0 + dp[i+1][transaction]
                    );
                }
                else{
                    dp[i][transaction] = Math.max(
                        prices[i] + dp[i+1][transaction+1],
                        0 + dp[i+1][transaction]
                    );
                }
            }
        }
        return dp[0][0];
    }
}