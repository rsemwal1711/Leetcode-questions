class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][5];

        // as -> Buy Sell Buy Sell.
        // so even index for Buy and Negative index for Sell.

        // size is n+1, 5 as we are doing +1 so to be safe from ArrayIndexOutOfBounds Exception.

        for(int i=n-1;i>=0;i--){
            for(int transaction=0;transaction<4;transaction++){
                int profit = 0;
                if(transaction % 2 == 0){
                    dp[i][transaction] = Math.max(
                        -prices[i] + dp[i+1][transaction+1],
                        0 + dp[i+1][transaction]
                    );
                }
                else{
                    dp[i][transaction] = profit = Math.max(
                        prices[i] + dp[i+1][transaction+1],
                        0 + dp[i+1][transaction]
                    );
                }
            }
        }
        return dp[0][0];
    }
}