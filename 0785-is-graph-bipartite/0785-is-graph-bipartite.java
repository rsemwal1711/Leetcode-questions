class Solution {
    public boolean bfs(int sr, int n, int[] color, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int adjNode : graph[node]){
                if(color[adjNode] == -1){
                    color[adjNode] = 1 - color[node];
                    q.add(adjNode);
                }
                else if(color[adjNode] == color[node]) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int col, int[] color, int[][] graph){
        color[node] = col;
        for(int adjNode : graph[node]){
            if(color[adjNode] == -1){
                if(dfs(adjNode, 1 - col, color, graph) == false) return false;
            }
            else if(color[node] == color[adjNode]) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                // if(!bfs(i, n, color, graph)){
                //     return false;
                // }
                if(!dfs(i, 0, color, graph)) return false;
            }
        }
        return true;
    }
}