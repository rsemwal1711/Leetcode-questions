class Solution {
    public void func(int i, int[] nums, List<Integer> temp, List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for(int j=i;j<nums.length;j++){
            temp.add(nums[j]);
            func(j+1, nums, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        func(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}