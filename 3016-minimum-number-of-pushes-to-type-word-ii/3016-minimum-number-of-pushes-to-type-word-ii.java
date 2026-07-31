class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(char c : word.toCharArray()){
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int pos = 0;
        int ans = 0;
        int a = 1;
        for(int i=25;i>=0 && freq[i] > 0;i--){
            if(pos == 8){
                a++;
                pos = 0;
            }
            ans += freq[i] * a;
            pos++;
        }
        return ans;
    }
}