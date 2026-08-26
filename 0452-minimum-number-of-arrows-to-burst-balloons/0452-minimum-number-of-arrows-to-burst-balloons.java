class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int i=0;
        int n = points.length;
        int ans = 0;
        while(i < n){
            int end = points[i][1];
            int j = i+1;
            while(j < n && end >= points[j][0] && end <= points[j][1]){
                j++;
            }
            ans++;
            i = j;
        }
        return ans;
    }
}