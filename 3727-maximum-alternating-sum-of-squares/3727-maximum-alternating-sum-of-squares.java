class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] < 0) nums[i] *= -1;
        }
        Arrays.sort(nums);
        long sum1 = 0;
        int i=0;
        int n2 = n / 2;
        while(i < n2){
            sum1 -= (long) nums[i] * nums[i];
            i++;
        }
        while(i < n){
            sum1 += (long) nums[i] * nums[i];
            i++;
        }
        return sum1;
    }
}