class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for(int i=0;i<arr1.length;i++){
            int closest = Integer.MAX_VALUE;
            for(int a : arr2){
                closest = Math.min(closest, Math.abs(a - arr1[i]));
            }
            if(closest > d) ans++;
        }
        return ans;
    }
}