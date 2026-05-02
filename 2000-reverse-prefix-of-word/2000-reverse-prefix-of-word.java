class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        int i=0;
        boolean found = false;
        for(i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c == ch){
                found = true;
                ans += c; 
                while(!st.isEmpty()){
                    ans += st.pop();
                }
                i++;
                break;
            }
            else{
                st.push(c);
            }
        }
        if(!found) return word;
        while(i < word.length()){
            ans += word.charAt(i);
            i++;
        }
        return ans;
    }
}