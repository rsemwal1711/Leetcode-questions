class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxi = -1;
        int j=1;
        while(j < n){
            if(colors[0] != colors[j]) maxi = Math.max(maxi, j-0);
            j++;
        }
        j=n-2;
        while(j >=0){
            if(colors[n-1] != colors[j]) maxi = Math.max(maxi, n-1-j);
            j--;
        }
        return maxi;
    }
}