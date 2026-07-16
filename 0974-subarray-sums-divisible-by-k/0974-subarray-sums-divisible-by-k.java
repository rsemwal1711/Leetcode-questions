class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefix = 0;
        int count = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        for(int i=0;i<n;i++){
            prefix += nums[i];
            int remainder = prefix % k;
            if(remainder < 0) remainder += k;
            if(mpp.containsKey(remainder)) count += mpp.get(remainder);
            mpp.put(remainder, mpp.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}