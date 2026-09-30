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
        // Boolean[][] dp = new Boolean[n][m];
        // return func(n-1, m-1, s, p, dp);

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int j=1;j<=m;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
}