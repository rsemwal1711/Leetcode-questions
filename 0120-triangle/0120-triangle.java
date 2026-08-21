class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        for(int j=0;j<n;j++){
            prev[j] = triangle.getLast().get(j);
        }
        for(int i=n-2;i>=0;i--){
            int[] curr = new int[n];
            for(int j=i;j>=0;j--){
                int down = prev[j];
                int diag = prev[j+1];
                curr[j] = triangle.get(i).get(j) + Math.min(down, diag);
            }
            prev = curr;
        }
        return prev[0];
    }
}