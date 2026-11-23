class Solution {
    public int func(int left, int right, String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;

        for(int i=0;i<s.length();i++){
            int len1 = func(i, i, s); // odd len
            int len2 = func(i, i+1, s); // even len
            int len = Math.max(len1, len2);
            if(len > maxLen){
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start+maxLen);
    }
}