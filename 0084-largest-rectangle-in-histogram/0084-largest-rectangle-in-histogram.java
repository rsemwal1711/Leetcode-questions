class Solution {
    public int[] nextSmaller(int[] heights, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] prevSmaller(int[] heights, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSml = nextSmaller(heights, n);
        int[] prevSml = prevSmaller(heights, n);
        int ans = 0;
        for(int i=0;i<n;i++){
            int height = heights[i];
            int width = nextSml[i] - prevSml[i] - 1;
            ans = Math.max(ans, height * width);
        }
        return ans;
    }
}