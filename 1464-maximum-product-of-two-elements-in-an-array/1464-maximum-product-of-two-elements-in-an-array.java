class Solution {
    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int secMaxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > maxi){
                secMaxi = maxi;
                maxi = nums[i];
            }
            else if(nums[i] > secMaxi){
                secMaxi = nums[i];
            }
        }
        return (maxi-1) * (secMaxi-1);
    }
}