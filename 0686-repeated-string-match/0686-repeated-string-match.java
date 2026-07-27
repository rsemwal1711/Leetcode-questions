class Solution {
    public boolean kmp(String text, String pattern){
        int i = 1;
        int j = 0;
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
        i=0;
        j=0;
        while(i < text.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j == pattern.length()) return true;
            else if(i < text.length() && text.charAt(i) != pattern.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return false;
    }
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }
        if(kmp(sb.toString(), b)) return count;
        sb.append(a);
        count++;
        if(kmp(sb.toString(), b)) return count;
        return -1;
    }
}