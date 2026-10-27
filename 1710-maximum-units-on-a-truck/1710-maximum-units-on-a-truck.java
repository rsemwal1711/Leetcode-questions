class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int ans = 0;
        for(int[] box : boxTypes){
            int val = 0;
            if(box[0] < truckSize){
                val = box[0];
                truckSize -= box[0];
            }
            else{
                val = truckSize;
                truckSize = 0;
            }
            ans += val * box[1];
            if(truckSize == 0) break;
        }
        return ans;
    }
}