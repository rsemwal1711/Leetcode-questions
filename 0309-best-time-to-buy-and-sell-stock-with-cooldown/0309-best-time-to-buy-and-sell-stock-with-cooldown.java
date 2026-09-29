class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead1 = new int[2];
        int[] ahead2 = new int[2];
        int[] curr = new int[2];
        for(int i=n-1;i>=0;i--){
            curr[1] = Math.max(
                -prices[i] + ahead1[0],
                0 + ahead1[1]
            );
            curr[0] = Math.max(
                prices[i] + ahead2[1],
                0 + ahead1[0]
            );
            int[] temp = ahead2;
            ahead2 = ahead1;
            ahead1 = curr;
            curr = temp;
        }
        return ahead1[1];
    }
}