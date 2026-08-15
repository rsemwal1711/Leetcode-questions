class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int countZero = 0;
        int maxLen = 0;
        while(right < n){
            if(nums[right] == 0){
                countZero++;
            }
            while(left < n && countZero > 1){
                if(nums[left] == 0){
                    countZero--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left);
            right++;
        }
        return maxLen;
    }
}