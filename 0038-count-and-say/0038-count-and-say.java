class Solution {
    public String countAndSay(int n) {
        if(n == 0) return "1";
        String str = "1";
        for(int i=0;i<n-1;i++){
            int j = 0;
            String s = "";
            while(j < str.length()){
                char c = str.charAt(j);
                int count = 0;
                while(j < str.length() && c == str.charAt(j)){
                    count++;
                    j++;
                }
                s += count;
                s += c;
            }
            str = s;
        }
        return str;
    }
}