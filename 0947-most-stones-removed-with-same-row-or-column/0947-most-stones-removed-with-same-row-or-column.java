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
    public int removeStones(int[][] stones) {
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for(int[] it : stones){
            maxRow = Math.max(maxRow, it[0]);
            maxCol = Math.max(maxCol, it[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        Set<Integer> set = new HashSet<>();
        for(int[] it : stones){
            int nrow = it[0];
            int ncol = maxRow + 1 + it[1];
            ds.unionBySize(nrow, ncol);
            set.add(nrow);
            set.add(ncol);
        }
        int cnt = 0;
        for(int it : set){
            if(it == ds.findUltimateParent(it)) cnt++;
        }
        return stones.length - cnt;
    }
}