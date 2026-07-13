class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while(right < n){
            if(nums[right] == 0) k--;
            while(k < 0){
                if(nums[left] == 0) k++;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}