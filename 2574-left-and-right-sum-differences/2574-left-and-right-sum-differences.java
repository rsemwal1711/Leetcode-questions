class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        // int[] prefix = new int[n];
        // int[] suffix = new int[n];
        // prefix[0] = 0;
        // suffix[n-1] = 0;
        // for(int i=1;i<n;i++) prefix[i] = prefix[i-1] + nums[i-1];
        // for(int i=n-2;i>=0;i--) suffix[i] = suffix[i+1] + nums[i+1];
        // int[] ans = new int[n];
        // for(int i=0;i<n;i++){
        //     ans[i] = Math.abs(prefix[i] - suffix[i]);
        // }
        // return ans;

        int sum = 0;
        for(int it : nums) sum += it;
        int leftSum = 0;
        int[] ans = new int [n];
        for(int i=0;i<n;i++){
            int rightSum = sum - nums[i] - leftSum;
            ans[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return ans;
    }
}