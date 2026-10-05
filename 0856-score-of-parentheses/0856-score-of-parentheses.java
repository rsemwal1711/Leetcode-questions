class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(0);
            }
            else{
                int score = 0;
                if(!st.isEmpty() && st.peek() == 0){
                    score = 1;
                    st.pop();
                }
                else{
                    score = st.pop() * 2;
                }
                if(st.isEmpty()) st.push(score);
                else st.push(score + st.pop());
            }
        }
        int ans = 0;
        while(!st.isEmpty()) ans += st.pop();
        return ans;
    }
}