class Solution {
    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public int func(int i, int n, String s, int[] dp){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int minCuts = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(i, j, s)){
                int cost = 1 + func(j+1, n, s, dp);
                minCuts = Math.min(minCuts, cost);
            }
        }
        return dp[i] = minCuts;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return func(0, n, s, dp) - 1;
        
        for(int i=n-1;i>=0;i--){
            int minCuts = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPalindrome(i, j, s)){
                    int cost = 1 + dp[j+1];
                    minCuts = Math.min(minCuts, cost);
                }
            }
            dp[i] = minCuts;
        }
        return dp[0] - 1;
    }
}