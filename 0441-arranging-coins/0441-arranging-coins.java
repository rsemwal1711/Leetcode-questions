class Solution {
    public int arrangeCoins(int n) {
        if(n == 1) return 1;
        int sum = 0;
        int i;
        int temp = n;
        for(i=1;i<=temp;i++){
            sum += i;
            n -= i;
            if(n < 0){
                return i-1;
            }
        }
        return i;
    }
}