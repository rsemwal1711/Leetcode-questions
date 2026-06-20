class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[256];
        for(char c : s.toCharArray()){
            freq[c]++;
        }
        boolean found = false;
        int count = 0;
        
        for(int it : freq){
            if(it % 2 == 0) count += it;
            else{
                count += it-1;
                found = true;
            }
        }
        if(found) count += 1;
        return count;
    }
}