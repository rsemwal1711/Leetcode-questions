class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = 0;
        int i = 0;
        int n = intervals.length;
        while(i < n) {
            int end = intervals[i][1];
            int j = i+1;
            while(j < n && end > intervals[j][0]){
                ans++;
                j++;
            }
            i = j;
        }
        return ans;
    }
}