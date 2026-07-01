class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            if(mpp.containsKey(target - nums[i])){
                ans[0] = mpp.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            else{
                mpp.put(nums[i], i);
            }
        }
        return ans;
    }
}