class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int currSum = 0;
        mpp.put(0, 1);
        int count = 0;
        for(int it : nums){
            currSum += it;
            if(mpp.containsKey(currSum - k)){
                count += mpp.get(currSum-k);
            }
            mpp.put(currSum, mpp.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}