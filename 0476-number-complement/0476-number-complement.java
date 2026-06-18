class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int pos = 0;
        while(num != 0){
            int a = 1 ^ (num&1);
            ans |= (a << pos);
            num >>= 1;
            pos++;
        }
        return ans;
    }
}