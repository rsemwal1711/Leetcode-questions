class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(mpp.containsKey(nums[i])){
                int diff = i - mpp.get(nums[i]);
                if(diff <= k) return true;
                else{
                    mpp.put(nums[i], i);
                }
            }
            else{
                mpp.put(nums[i], i);
            }
        }
        return false;
    }
}