class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        int target = sum / 2;

        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        if(nums[0] <= target) prev[nums[0]] = true;
        for(int i=1;i<n;i++){
            boolean[] curr = new boolean[target+1];
            curr[0] = true;
            for(int k=1;k<=target;k++){
                boolean notTake = prev[k];
                boolean take = false;
                if(nums[i] <= k) take = prev[k-nums[i]];
                curr[k] = take || notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}