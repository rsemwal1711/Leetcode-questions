class Solution {
    public void dfs(int node, int[][] isConnected, boolean[] vis, int n){
        vis[node] = true;
        for(int i=0;i<n;i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(i, isConnected, vis, n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i, isConnected, vis, n);
            }
        }
        return count;
    }
}