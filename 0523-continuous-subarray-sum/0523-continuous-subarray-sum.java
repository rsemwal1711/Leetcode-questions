class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefix = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1);
        for(int i=0;i<nums.length;i++){
            prefix += nums[i];
            int remainder = prefix % k;
            if(mpp.containsKey(remainder)){
                if(i - mpp.get(remainder) >= 2) return true;
            }
            else mpp.put(remainder, i);
        }
        return false;
    }
}