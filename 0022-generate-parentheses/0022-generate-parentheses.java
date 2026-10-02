class Solution {
    public void func(int n, String temp, List<String> ans, int open, int close){
        if(open == n && close == n){
            ans.add(temp);
            return;
        }
        if(open < n) func(n, temp + '(', ans, open+1, close);
        if(close < open) func(n, temp + ')', ans, open, close+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        func(n, "", ans, 0, 0);
        return ans;
    }
}