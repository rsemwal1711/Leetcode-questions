class Solution {
    public int atMostK(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right < n){
            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0) + 1);
            while(mpp.size() > k){
                mpp.put(nums[left], mpp.getOrDefault(nums[left], 0) - 1);
                if(mpp.get(nums[left]) == 0) mpp.remove(nums[left]);
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }
}