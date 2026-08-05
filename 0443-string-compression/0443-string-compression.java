class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int ans = 0;
        int i = 0;
        int k = 0;
        while(i < n){
            char c = chars[i];
            int cnt = 1;
            while(i < n-1 && c == chars[i+1]){
                cnt++;
                i++;
            }
            i++;
            chars[k++] = c;
            ans += 1;
            if(cnt > 1){
                String str = cnt + "";
                for(int j=0;j<str.length();j++){
                    ans++;
                    chars[k++] = str.charAt(j);
                }
            }
        }
        return ans;
    }
}