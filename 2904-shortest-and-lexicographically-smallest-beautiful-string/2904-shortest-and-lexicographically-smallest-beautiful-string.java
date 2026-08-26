class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int countOnes = 0;
        String ans = "";
        while(right < n){
            char c = s.charAt(right);
            if(c == '1') countOnes++;

            while(countOnes == k){
                if(s.charAt(left) == '1'){
                    countOnes--;
                }
                int len = right - left + 1;
                if(len < minLen){
                    minLen = len;
                    ans = s.substring(left, left + minLen);
                }
                else if(len == minLen){
                    String curr = s.substring(left, left + minLen);
                    if(curr.compareTo(ans) < 0){
                        ans = curr;
                    }
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}