class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int n = word.length();
        while(i < n){
            char c = word.charAt(i);
            int count = 0;
            while(i < n && c == word.charAt(i) && count != 9){
                count++;
                i++;
            }
            sb.append(count).append(c);
        }
        return sb.toString();
    }
}