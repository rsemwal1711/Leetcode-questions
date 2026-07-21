class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] iknow = new int[n+1];
        int[] knowme = new int[n+1];
        for(int[] it : trust){
            int a = it[0];
            int b = it[1];
            iknow[a]++;
            knowme[b]++;
        }
        for(int i=1;i<=n;i++){
            if(iknow[i] == 0 && knowme[i] == n-1) return i;
        }
        return -1;
    }
}