class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int ans = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        while(right < n) {
            char c = s.charAt(right);
            freq[c-'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                ans += s.length() - right;
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
}