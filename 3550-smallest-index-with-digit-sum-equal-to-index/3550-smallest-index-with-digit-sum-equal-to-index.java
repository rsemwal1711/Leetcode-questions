class Solution {
    public int sumOfDigits(int n){
        int temp = n;
        int sum = 0;
        while(temp != 0){
            int digit = temp%10;
            sum += digit;
            temp /= 10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i == sumOfDigits(nums[i])) return i;
        }
        return -1;
    }
}