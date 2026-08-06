class Solution {
    public int digitsProduct(int n){
        int product = 1;
        int temp = n;
        while(temp != 0){
            int digit = temp % 10;
            product *= digit;
            temp /= 10;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        if(n == 0) return 0;
        while(true){
            if(digitsProduct(n) % t == 0) return n;
            n++;
        }
    }
}