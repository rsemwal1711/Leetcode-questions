class Solution {
    public boolean func(int i, int j, String s, String p, Boolean[][] dp){
        if(i < 0){
            for(int jj=0;jj<=j;jj++){
                if(p.charAt(jj) != '*') return false;
            }
            return true;
        }
        if(j < 0) return false;
        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = func(i-1, j-1, s, p, dp);
        }
        else if(p.charAt(j) == '*'){
            return dp[i][j] = func(i-1, j, s, p, dp) || func(i, j-1, s, p, dp);
        }
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return func(n-1, m-1, s, p, dp);
    }
}