class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int prefix = 0;
        mpp.put(0, -1);
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) prefix--;
            else prefix++;
            if(mpp.containsKey(prefix)){
                ans = Math.max(ans, i-mpp.get(prefix));
            }
            else mpp.put(prefix, i);
        }
        return ans;
    }
}