class Solution {
    public void solve(int[] nums, boolean[] vis, int i, List<Integer> temp, List<List<Integer>> ans){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(!vis[j]){
                temp.add(nums[j]);
                vis[j] = true;
                solve(nums, vis, j, temp, ans);
                temp.remove(temp.size()-1);
                vis[j] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        solve(nums, vis, 0, new ArrayList<>(), ans);
        return ans;
    }
}