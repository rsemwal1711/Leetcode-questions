class Solution {
    public int rob(int[] nums) {
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
    }
}