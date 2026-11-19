class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j=0;
        for(int i=0;i<popped.length;i++){
            if(!st.isEmpty() && popped[i] == st.peek()){
                st.pop();
                continue;
            }
            while(j < pushed.length && popped[i] != pushed[j]){
                st.push(pushed[j]);
                j++;
            }
            if(j == pushed.length) return false;
            j++;
        }
        return st.isEmpty();
    }
}