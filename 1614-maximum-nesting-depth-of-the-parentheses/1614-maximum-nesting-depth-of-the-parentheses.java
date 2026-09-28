class Solution {
    public int maxDepth(String s) {
        int leftBrace = 0;
        int rightBrace = 0;
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c == '(') leftBrace++;
            else if(c == ')') rightBrace++;
            ans = Math.max(ans, leftBrace - rightBrace);
        }
        return ans;
    }
}