class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length < 3) return 0;
        int ans = 0;
        int i=1;
        while(i < arr.length-1){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                int left = i;
                int right = i;
                while(left > 0 && arr[left] > arr[left-1]){
                    left--;
                }
                while(right < arr.length-1 && arr[right] > arr[right+1]){
                    right++;
                }
                ans = Math.max(ans, right-left+1);
            }
            i++;
        }
        return ans;
    }
}