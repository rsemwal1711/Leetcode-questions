class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] suffix = new int[n];
        suffix[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1] + nums[i+1];
        }
        int prefix = 0;
        for(int i=0;i<n;i++){
            if(prefix == suffix[i]) return i;
            prefix += nums[i];
        }
        return -1;
    }
}