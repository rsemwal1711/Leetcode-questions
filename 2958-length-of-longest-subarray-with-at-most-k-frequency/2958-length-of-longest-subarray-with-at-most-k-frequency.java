class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = nums.length;
        int maxLen = 0;
        while(right < n){
            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0) + 1);
            while(mpp.get(nums[right]) > k){
                mpp.put(nums[left], mpp.get(nums[left]) - 1);
                if(mpp.get(nums[left]) == 0) mpp.remove(nums[left]);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}