class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        int sign = 1;
        s = s.trim();
        int n = s.length();
        if(n == 0) return 0;
        int i=0;
        if(s.charAt(0) == '-'){
            sign = -1;
            i++;
        }
        else if(s.charAt(0) == '+'){
            i++;
        }
        while(i < n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            ans = ans * 10 + digit;
            if(ans * sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else if(ans * sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (ans * sign);
    }
}