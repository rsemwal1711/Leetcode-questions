class Solution {
    public int maxProduct(int n) {
        int maxi = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        while(n!=0){
            int digit = n%10;
            if(digit >= maxi){
                secMax = maxi;
                maxi = digit;
            }
            else if(digit >= secMax && digit != maxi){
                secMax = digit;
            }
            n/=10;
        }
        return maxi * secMax;
    }
}