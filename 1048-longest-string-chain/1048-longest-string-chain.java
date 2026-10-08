class Solution {
    public boolean compare(String s1, String s2){
        int i=0, j=0;
        int n = s1.length();
        int m = s2.length();
        if(n != m+1) return false;
        while(i < n){
            if(j < m && s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            i++;
        }
        return i == n && j == m;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[n];
        int maxi = 1;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(compare(words[i], words[j]) && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}