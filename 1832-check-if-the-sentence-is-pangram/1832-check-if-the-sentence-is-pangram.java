class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        for(char c : sentence.toCharArray()){
            freq[c - 'a'] = 1;
        }
        for(int i=0;i<26;i++){
            if(freq[i] == 0) return false;
        }
        return true;
    }
}