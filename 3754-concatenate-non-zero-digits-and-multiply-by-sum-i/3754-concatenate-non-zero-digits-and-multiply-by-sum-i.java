class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long num = 0;
        long power = 1;
        while(n!=0){
            int digit = n%10;
            if(digit != 0){
                num = digit*power + num;
                sum += digit;
                power *= 10;
            }
            n/=10;
        }
        return (int) num*sum;
    }
}