class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int studentIndex = 0;
        int cookieIndex = 0;
        while(studentIndex < g.length && cookieIndex < s.length){
            if(s[cookieIndex] >= g[studentIndex]){
                studentIndex++;
            }
            cookieIndex++;
        }
        return studentIndex;
    }
}