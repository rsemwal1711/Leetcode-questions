class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> st = new HashSet<>();
        for(int it : nums){
            st.add(it);
        }
        int maxLen = Integer.MIN_VALUE;
        for(int it : st){
            int curr = it;
            int len = 1;
            if(!st.contains(curr - 1)){
                while(st.contains(curr+1)){
                    curr++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}