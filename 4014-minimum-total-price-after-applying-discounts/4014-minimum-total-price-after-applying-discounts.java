class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i = prices.length-1;
        int j = discounts.length-1;
        double ans = 0;
        while(i >= 0){
            int dis = j<0 ? 0 : discounts[j];
            ans += (double) (prices[i] * (100 - dis)) / 100;
            i--;
            j--;
        }
        return ans;
    }
}