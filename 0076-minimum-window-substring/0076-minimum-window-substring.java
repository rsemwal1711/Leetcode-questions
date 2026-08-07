class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[256];
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        int m = t.length();
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        while(right < n){
            char c1 = s.charAt(right);
            if(freq[c1] > 0) count++;
            freq[c1]--;
            while(count == m){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    startIndex = left;
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)] > 0) count--;
                left++;
            }
            right++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}