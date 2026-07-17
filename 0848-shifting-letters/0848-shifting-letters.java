class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder(s);
        int n = shifts.length;
        long prefix = 0;
        for(int i=0;i<n;i++){
            prefix += shifts[i];
        }
        for(int i=0;i<n;i++){
            char c = sb.charAt(i);
            int temp = (int) (prefix % 26);
            int index = c - 'a';
            int newIndex = (index + temp) % 26;
            c = (char) ('a' + newIndex);
            sb.setCharAt(i, c);
            prefix -= shifts[i];
        }
        return sb.toString();
    }
}