class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        long ans = 0;
        long sum = 0;
        while(right < n){
            sum += nums[right];
            int len = right - left + 1;
            while(sum * len >= k){
                sum -= nums[left];
                len--;
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}