class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        int n = nums.length;
        for(int it : nums) freq[it]++;
        if(k == n){
            int maxi = Integer.MIN_VALUE;
            for(int it : nums) maxi = Math.max(maxi, it);
            return maxi == Integer.MIN_VALUE ? -1 : maxi;
        }
        if(k == 1){
            for(int i=50;i>=0;i--){
                if(freq[i] == 1) return i;
            }
            return -1;
        }
        int maxi = Integer.MIN_VALUE;
        if(freq[nums[0]] == 1) maxi = Math.max(maxi, nums[0]);
        if(freq[nums[n-1]] == 1) maxi = Math.max(maxi, nums[n-1]);

        return maxi == Integer.MIN_VALUE ? -1 : maxi;
    }
}