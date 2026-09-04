class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 && nums[0] == k) return 0;
        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = Math.min(suffix[i+1], nums[i]);
        }
        int prefix = nums[0];
        if(prefix - suffix[0] <= k) return 0;
        for(int i=1;i<n;i++){
            prefix = Math.max(prefix, nums[i]);
            if(prefix - suffix[i] <= k) return i;
        }
        return -1;
    }
}