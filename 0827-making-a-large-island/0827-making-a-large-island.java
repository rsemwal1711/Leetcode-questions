class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    DisjointSet(int V){
        for(int i=0;i<V;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUltimateParent(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUltimateParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public void connectInitial_1s(int[][] grid, int n, DisjointSet ds){
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 0) continue;
                int[] delrow = {-1, 0, 1, 0};
                int[] delcol = {0, 1, 0, -1};
                for(int i=0;i<4;i++){
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1){
                        int node = row * n + col;
                        int newNode = nrow * n + ncol;
                        ds.unionBySize(node, newNode);
                    }
                }
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        connectInitial_1s(grid, n, ds);

        int maxi = 0;

        // Checking the 0s now
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 1) continue;
                int[] delrow = {-1, 0, 1, 0};
                int[] delcol = {0, 1, 0, -1};
                Set<Integer> components = new HashSet<>();
                for(int i=0;i<4;i++){
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1){
                        components.add(ds.findUltimateParent(nrow * n + ncol));
                    }
                }
                int size = 1;
                for(int parent : components){
                    size += ds.size.get(parent);
                }
                maxi = Math.max(size, maxi);
            }
        }
        for(int i=0;i<n*n;i++){
            maxi = Math.max(maxi, ds.size.get(i));
        }
        return maxi;
    }
}