class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int index = 0;
        for(int it : nums){
            if(it < pivot){
                ans[index++] = it;
            }
        }
        for(int it : nums){
            if(it == pivot){
                ans[index++] = it;
            }
        }
        for(int it : nums){
            if(it > pivot){
                ans[index++] = it;
            }
        }
        return ans;
    }
}