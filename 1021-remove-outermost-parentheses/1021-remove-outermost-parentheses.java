class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        String ans = "";
        int open = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                open++;
                if(open > 1) ans += c;
            }
            else{
                open--;
                if(open != 0){
                    ans += c;
                }
            }
        }
        return ans;
    }
}