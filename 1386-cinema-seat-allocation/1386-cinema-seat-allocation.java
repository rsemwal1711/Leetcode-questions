class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> mpp = new HashMap<>();
        for(int[] reserved : reservedSeats){
            mpp.putIfAbsent(reserved[0], new HashSet<>());
            mpp.get(reserved[0]).add(reserved[1]);
        }
        int ans = (n - mpp.size()) * 2;
        for(Map.Entry<Integer, Set<Integer>> entry : mpp.entrySet()){
            int row = entry.getKey();
            boolean found2 = false;
            boolean found4 = false;
            Set<Integer> set = entry.getValue();

            if(!set.contains(2) && !set.contains(3) &&
                !set.contains(4) && !set.contains(5))
            {
                found2 = true;
                ans++;
            }
            if(!found2){
                if(!set.contains(4) && !set.contains(5) &&
                    !set.contains(6) && !set.contains(7))
                {
                    found4 = true;
                    ans++;
                }
            }
            if(!found4){
                if(!set.contains(6) && !set.contains(7) &&
                    !set.contains(8) && !set.contains(9))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}