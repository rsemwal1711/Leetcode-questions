class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ans = new HashSet<>();
        int right = 0;
        Set<String> st = new HashSet<>();

        while(right <= s.length() - 10){
            String a = s.substring(right, right + 10);
            if(!st.isEmpty() && st.contains(a)){
                ans.add(a);
            }
            else{
                st.add(a);
            }
            right++;
        }
        return new ArrayList<>(ans);
    }
}