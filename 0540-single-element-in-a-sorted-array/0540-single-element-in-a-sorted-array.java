class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = (low + high) / 2;
            int firstOcc = mid;
            if(mid > 0 && nums[mid] == nums[mid-1]){
                firstOcc = mid-1;
            }
            else if(mid < nums.length-1 && nums[mid] == nums[mid+1]){
                firstOcc = mid;
            }
            else{
                return nums[mid];
            }
            if(firstOcc % 2 == 0){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return nums[low];
    }
}