class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        for(char c : s.toCharArray()) freq[c - 'a']++;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            freq[c - 'a']--;
            if(vis[c - 'a']) continue;
            while(!st.isEmpty() && c < st.peek() && freq[st.peek() - 'a'] > 0){
                vis[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(c);
            vis[c - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.append(st.pop());
        return ans.reverse().toString();
    }
}