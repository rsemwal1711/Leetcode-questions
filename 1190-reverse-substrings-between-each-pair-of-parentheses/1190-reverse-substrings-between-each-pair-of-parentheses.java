class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        int i = 0;
        int n = s.length();
        while(i < n){
            char c = s.charAt(i);
            if(c != ')'){
                st.push(c);
                i++;
            }
            else{
                String str = "";
                while(!st.isEmpty() && st.peek() != '('){
                    str += st.pop();
                }
                i++;
                st.pop();
                for(int j=0;j<str.length();j++){
                    st.push(str.charAt(j));
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}