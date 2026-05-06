class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] hash = new int[256];
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        Arrays.fill(hash,-1);
        for(int right=0;right<n;right++){
            if(hash[s.charAt(right)] >= left){
                left = Math.max(left, hash[s.charAt(right)] + 1);
            }
            hash[s.charAt(right)] = right;
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}