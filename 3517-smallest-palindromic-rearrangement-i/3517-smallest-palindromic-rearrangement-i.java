class Solution {
    public String smallestPalindrome(String s) {
        if(s.length() <= 2) return s; 
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        int middle = -1;
        for(int i=0;i<26;i++){
            if(freq[i] % 2 == 1) middle = i;
            int a = freq[i] / 2;
            while(a != 0){
                ans.append((char) ('a' + i));
                a-=1;
            }
        }
        StringBuilder ansRev = new StringBuilder(ans);
        if(middle != -1) ans.append((char) ('a' + middle));
        String a = ansRev.reverse().toString();
        return ans.toString() + a;
    }
}