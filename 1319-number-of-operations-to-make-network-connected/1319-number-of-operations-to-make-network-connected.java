class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUltimateParent(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUltimateParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int a, int b){
        int ulp_u = findUltimateParent(a);
        int ulp_v = findUltimateParent(b);
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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        for(int[] it : connections){
            int u = it[0];
            int v = it[1];
            if(ds.findUltimateParent(u) == ds.findUltimateParent(v)){
                cntExtras++;
            }
            else{
                ds.unionBySize(u, v);
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i) == i) cnt++;
        }
        int ans = cnt - 1;
        return cntExtras >= ans ? ans : -1;
    }
}