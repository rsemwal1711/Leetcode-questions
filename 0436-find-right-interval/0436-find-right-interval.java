class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for(int i=0;i<n;i++){
            int endI = arr[i][1];
            int index = -1;
            int low = i;
            int high = n-1;
            while(low <= high){
                int mid = (low + high) / 2;
                if(arr[mid][0] >= endI){
                    index = arr[mid][2];
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            ans[arr[i][2]] = index;
        }
        return ans;
    }
}