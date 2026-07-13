class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i=0;i<n;i++){
            int left = 0;
            int right = n-1;
            while(left < right){
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;

                image[i][left] = image[i][left] == 1 ? 0 : 1;
                image[i][right] = image[i][right] == 1 ? 0 : 1;
                
                left++;
                right--;
            }
            if(n%2 == 1){
                image[i][n/2] = image[i][n/2] == 1 ? 0 : 1;
            }
        }
        return image;
    }
}