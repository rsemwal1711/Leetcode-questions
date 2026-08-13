class Solution {
    public int rob_memoization(int n, int[] nums, int[] dp){
        if(n == 0) return nums[0];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        int pick = nums[n] + rob_memoization(n-2, nums, dp);
        int notpick = rob_memoization(n-1, nums, dp);
        return dp[n] = Math.max(pick, notpick);
    }
    public int rob_tabulation(int n, int[] nums, int[] dp){
        if(n == 0) return 0;
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i > 1) pick += dp[i-2];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        // MEMOIZATIONS APPROACH : 
        /*
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return rob_memoization(n-1, nums, dp);
        */

        // TABULATION APPROACH : 
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return rob_tabulation(n, nums, dp);

        // SPACE OPTIMIZATION APPROACH : 

        /*
        if(nums.length == 0) return 0;
        int prev = nums[0];
        if(nums.length == 1) return prev;
        int prev2 = 0;
        for(int i=1;i<nums.length;i++){
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int notpick = prev;
            prev2 = prev;
            prev = Math.max(pick, notpick);
        }
        return prev;
        */
    }
}