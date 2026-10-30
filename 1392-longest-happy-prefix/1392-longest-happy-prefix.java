class Solution {
    public int[] buildLPS(String pattern){
        int i=1;
        int j=0;
        int n = pattern.length();
        int[] lps = new int[n];
        while(i < n){
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            else{
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = buildLPS(s);
        return s.substring(0, lps[n-1]);
    }
}