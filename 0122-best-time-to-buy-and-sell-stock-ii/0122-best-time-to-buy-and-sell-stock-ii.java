class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadBuy, aheadNotBuy, currBuy, currNotBuy;
        aheadBuy = aheadNotBuy = 0;
        for(int i=n-1;i>=0;i--){
            currBuy = Math.max(
                -prices[i] + aheadNotBuy,
                0 + aheadBuy
            );
            currNotBuy = Math.max(
                prices[i] + aheadBuy,
                0 + aheadNotBuy
            );
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}