class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for(int it : costs){
            if(coins >= it){
                coins -= it;
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}