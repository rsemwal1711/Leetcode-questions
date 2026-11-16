class Solution {
    public String digitSum(String s, int k) {
        String ans = "";
        while(s.length() > k){
            int n = s.length();
            int i=0;
            while(i < n){
                int j = i;
                int count = 0;
                while(j < Math.min(i+k, n)){
                    count += s.charAt(j) - '0';
                    j++;
                }
                i = j;
                ans += count;
            }
            s = ans;
            ans = "";
        }
        return s;
    }
}