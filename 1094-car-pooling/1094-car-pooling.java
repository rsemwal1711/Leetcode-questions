class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] changes = new int[1001];
        for(int[] trip : trips){
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            changes[from] += passengers;
            changes[to] -= passengers;
        }
        for(int i=0;i<1001;i++){
            capacity -= changes[i];
            if(capacity < 0) return false;
        }
        return true;
    }
}