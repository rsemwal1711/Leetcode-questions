class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n!=1){
            int sum = 0;
            int temp = n;
            while(temp>0){
                int digit = temp%10;
                sum += digit*digit;
                temp/=10;
            }
            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            n = sum;
        }
        return true;
    }
}