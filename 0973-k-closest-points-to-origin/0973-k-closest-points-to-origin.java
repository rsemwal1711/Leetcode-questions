class Solution {
    public int func(int[] points){
        return points[0] * points[0] + points[1] * points[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> func(b) - func(a));
        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
            if(pq.size() > k) pq.poll();
        }
        int[][] ans = new int[pq.size()][2];
        int i=0;
        while(!pq.isEmpty()){
            ans[i] = pq.poll();
            i++;
        }
        return ans;
    }
}