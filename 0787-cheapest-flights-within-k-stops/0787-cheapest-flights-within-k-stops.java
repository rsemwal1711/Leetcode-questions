class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] it : flights){
            adj.get(it[0]).add(new int[]{it[1], it[2]});
        }
        pq.add(new int[]{0, src, 0}); // steps, node, distance
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int steps = p[0];
            int node = p[1];
            int dis = p[2];
            if(steps > k) continue;
            for(int[] it : adj.get(node)){
                int adjNode = it[0];
                int egW = it[1];
                if(dis + egW < dist[adjNode]){
                    dist[adjNode] = dis + egW;
                    pq.add(new int[]{steps+1, adjNode, dis + egW});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}