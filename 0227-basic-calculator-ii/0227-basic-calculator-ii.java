class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int number = 0;
        char op = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = (number*10) + (c - '0'); 
            }
            else if(c != ' ' || i == s.length()-1){
                if(op == '+'){
                    st.push(+number);
                }
                else if(op == '-'){
                    st.push(-number);
                }
                else if(op == '*'){
                    st.push(st.pop() * number);
                }
                else if(op == '/'){
                    st.push(st.pop() / number);
                }
                op = c;
                number = 0;
            }
        }
        if(op == '+') st.push(number);
        else if(op == '-') st.push(-number);
        else if(op == '*') st.push(st.pop() * number);
        else if(op == '/') st.push(st.pop() / number);

        int ans = 0;
        while(!st.isEmpty()) ans += st.pop();
        return ans;
    }
}