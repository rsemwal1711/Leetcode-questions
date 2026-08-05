class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            int digit1 = num1.charAt(i) - '0';
            for(int j=n2-1;j>=0;j--){
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;
                int sum = product + res[i+j+1];
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }
        int i=0;
        while(i < res.length && res[i] == 0){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(i < res.length){
            sb.append(res[i]);
            i++;
        }
        return sb.toString();
    }
}