class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        for(int i=0;i<n;i++){
            if(nums[i] > maxi){
                maxi = nums[i];
                maxIndex = i;
            }
            if(nums[i] < mini){
                mini = nums[i];
                minIndex = i;
            }
        }
        int left = Math.max(minIndex, maxIndex) + 1;
        int right = n - Math.min(minIndex, maxIndex);
        int bothSides = Math.min(minIndex, maxIndex) + 1 + n - Math.max(minIndex, maxIndex);
        return Math.min(left, Math.min(right, bothSides));
    }
}