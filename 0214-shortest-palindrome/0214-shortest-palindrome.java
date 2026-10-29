class Solution {
    public int[] buildLPS(String pattern){
        int i=1;
        int j=0;
        int[] lps = new int[pattern.length()];
        while(i < pattern.length()){
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
    public String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev = rev.reverse();
        String str = s + "#" + rev.toString();
        int[] lps = buildLPS(str);
        return rev.substring(0, s.length() - lps[str.length()-1]) + s;
    }
}