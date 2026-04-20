class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        int maxi = -1;
        for(int i=n-1;i>=0;i--){
            res[i] = maxi;
            maxi = Math.max(maxi, arr[i]);
        }
        return res;
    }
}