class Solution {
    public void reverse(int[][] matrix, int row){
        int i=0;
        int j = matrix.length-1;
        while(i < j){
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][j];
            matrix[row][j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] transpose = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                transpose[i][j] = matrix[j][i];
            }
            reverse(transpose, i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = transpose[i][j];
            }
        }
    }
}