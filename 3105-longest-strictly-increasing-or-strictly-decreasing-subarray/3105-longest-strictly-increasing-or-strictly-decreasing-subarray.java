class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int count = 1;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]){
                count++;
            }
            else{
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        count = 1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] > nums[i+1]){
                count++;
            }
            else{
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}