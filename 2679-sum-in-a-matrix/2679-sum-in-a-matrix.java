class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        for(int i=0;i<n;i++){
            Arrays.sort(nums[i]);
        }
        int[] ans = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j] = Math.max(ans[j], nums[i][j]);
            }
        }
        int sum = 0;
        for(int i=0;i<m;i++) sum += ans[i];
        return sum;
    }
}