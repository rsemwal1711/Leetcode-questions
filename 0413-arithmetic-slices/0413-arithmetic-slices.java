class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        int[] arr = new int[n-1];
        for(int i=0;i<n-1;i++){
            arr[i] = nums[i+1] - nums[i];
        }
        
        int count = 0;
        int len = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == arr[i-1]) len++;
            else{
                if(len >= 2) count += len*(len-1)/2;
                len = 1;
            }
        }
        if(len >= 2) count += len*(len-1)/2;
        return count;
    }
}