class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            int a = 122 - s.charAt(i) + 1;
            ans += a * (i+1);
        }
        return ans;
    }
}