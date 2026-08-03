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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail, i);
                }
                else{
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }
        List<List<String>> merge = new ArrayList<>();
        for(int i=0;i<n;i++) merge.add(new ArrayList<>());
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String mail = entry.getKey();
            int node = ds.findUltimateParent(entry.getValue());
            merge.get(node).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merge.get(i).isEmpty()) continue;
            Collections.sort(merge.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String str : merge.get(i)){
                temp.add(str);
            }
            ans.add(temp);
        }
        ans.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        return ans;
    }
}