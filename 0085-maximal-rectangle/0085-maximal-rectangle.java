class Solution {
    public int[] prevSmaller(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] nextSmaller(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int maxArea(int[] arr){
        int n = arr.length;
        int[] prev = prevSmaller(arr);
        int[] next = nextSmaller(arr);
        int maxAns = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int width = next[i] - prev[i] - 1;
            maxAns = Math.max(maxAns, width * arr[i]);
        }
        return maxAns;
    } 
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int maxAns = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '1'){
                    arr[j] += 1;
                }
                else{
                    arr[j] = 0;
                }
            }
            maxAns = Math.max(maxAns, maxArea(arr));
        }
        return maxAns;
    }
}