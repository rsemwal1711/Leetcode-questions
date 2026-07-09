class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        int[] freq = new int[256];
        while(right < n){
            freq[s.charAt(right)]++;
            while(freq[s.charAt(right)] >= 2){
                freq[s.charAt(left)]--;
                left++;
            }
            length = Math.max(length, right-left+1);
            right++;
        }
        return length;
    }
}