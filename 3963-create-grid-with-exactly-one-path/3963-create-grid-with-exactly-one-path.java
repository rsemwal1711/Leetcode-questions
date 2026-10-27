class Solution {
    public String[] createGrid(int m, int n) {
        String[] str = new String[m];
        for(int i=0;i<m;i++){
            String ans = "";
            if(i == 0){
                for(int j=0;j<n;j++){
                    ans += '.';
                }
            }
            else{
                for(int j=0;j<n-1;j++){
                    ans += '#';
                }
                ans += '.';
            }
            str[i] = ans;
        }
        return str;
    }
}