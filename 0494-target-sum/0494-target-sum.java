class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        int k = (totalSum + target) / 2;
        if(Math.abs(target) > totalSum) return 0;
        if( (totalSum + target) % 2 != 0) return 0;

        int n = nums.length;
        int[] prev = new int[k+1];
        prev[0] = 1;
        if(nums[0] <= k) prev[nums[0]] += 1;

        for(int i=1;i<n;i++){
            int[] curr = new int[k+1];
            for(int j=0;j<=k;j++){
                int notTake = prev[j];
                int take = 0;
                if(nums[i] <= j) take = prev[j - nums[i]];
                curr[j] = take + notTake;
            }
            prev = curr;
        }
        return prev[k];
    }
}