class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && prices[i] < st.peek()){
                st.pop();
            }
            ans[i] = st.isEmpty() ? prices[i] : prices[i] - st.peek();
            st.push(prices[i]);
        }
        return ans;
    }
}