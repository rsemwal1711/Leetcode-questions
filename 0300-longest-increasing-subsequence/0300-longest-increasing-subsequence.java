class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++){
            int maxi = Integer.MIN_VALUE;
            for(int j=0;j<=i-1;j++){
                if(nums[i] > nums[j]) maxi = Math.max(maxi, 1 + dp[j]);
            }
            dp[i] = Math.max(dp[i], maxi);
        }
        int ans = Integer.MIN_VALUE;
        for(int num : dp){
            ans = Math.max(ans, num);
        }
        return ans;
    }
}