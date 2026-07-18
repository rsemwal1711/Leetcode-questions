class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    public int findGCD(int[] nums) {
        int mini = nums[0];
        int maxi = nums[0];
        for(int i=1;i<nums.length;i++){
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }
        return gcd(mini, maxi);
    }
}