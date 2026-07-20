class Solution {
    public void func(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int last = grid[n-1][m-1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int temp = grid[i][j];
                grid[i][j] = last;
                last = temp;
            }
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<k;i++){
            func(grid);
        }
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<m;j++){
                list.add(grid[i][j]);
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}