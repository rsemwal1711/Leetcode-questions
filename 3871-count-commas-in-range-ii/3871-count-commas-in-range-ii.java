class Solution {
    public long countCommas(long n) {
        if(n < 1000) return 0;
        
        long ans = 0;
        
        if(n >= 1000L) ans += Math.min(n, 999999L) - 1000L + 1;
        if(n >= 1000000L) ans += (Math.min(n, 999999999L) - 1000000L + 1) * 2;
        if(n >= 1000000000L) ans += (Math.min(n, 999999999999L) - 1000000000L + 1) * 3;
        if(n >= 1000000000000L) ans += (Math.min(n, 999999999999999L) - 1000000000000L + 1) * 4;
        if(n >= 1000000000000000L) ans += (n - 1000000000000000L + 1) * 5;
        return ans;
    }
}