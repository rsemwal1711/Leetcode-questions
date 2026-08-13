class Solution {
    public int func(int n, List<Integer> list){
        int prev = list.getFirst();
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = list.get(i);
            if(i > 1) pick += prev2;
            int notpick = prev;
            prev2 = prev;
            prev = Math.max(pick, notpick);
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i != 0) temp1.add(nums[i]);
            if(i != n-1) temp2.add(nums[i]);
        }
        int ans1 = func(n-1, temp1);
        int ans2 = func(n-1, temp2);
        return Math.max(ans1, ans2);
    }
}