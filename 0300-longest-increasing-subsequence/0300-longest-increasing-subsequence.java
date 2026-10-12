class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxi = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}