class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int) (1e9+7);
        List<List<long[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it : roads){
            adj.get(it[0]).add(new long[]{it[1], it[2]});
            adj.get(it[1]).add(new long[]{it[0], it[2]});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0}); // distance_sum, node;
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        while(!pq.isEmpty()){
            long[] it = pq.poll();
            long dis = it[0];
            int node = (int) it[1];
            if (dis > dist[node]) continue;
            for(int i=0;i<adj.get(node).size();i++){
                long egW = adj.get(node).get(i)[1];
                int adjNode = (int) adj.get(node).get(i)[0];
                if(egW + dis < dist[adjNode]){
                    dist[adjNode] = egW + dis;
                    ways[adjNode] = ways[node];
                    pq.add(new long[]{egW + dis, adjNode});
                }
                else if(dist[adjNode] == dis + egW){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }
        return ways[n-1] % MOD;
    }
}