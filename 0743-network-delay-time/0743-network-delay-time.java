class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] it : times){
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            adj.get(u).add(new int[]{v, wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for(int[] it : adj.get(k)){
            int v = it[0];
            int wt = it[1];
            dist[v] = wt;
            pq.add(new int[]{wt, k, v});
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int[] it = pq.poll();
            int wt = it[0];
            int u = it[1];
            int v = it[2];
            for(int p[] : adj.get(v)){
                int adjNode = p[0];
                int edW = p[1];
                if(edW + wt < dist[adjNode]){
                    dist[adjNode] = edW + wt;
                    pq.add(new int[]{edW + wt, v, adjNode});
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}