class Solution {
    public void func(int i, int target, int[] arr, List<Integer> temp, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i >= arr.length || target < 0) return;
        temp.add(arr[i]);
        func(i, target - arr[i], arr, temp, ans);
        temp.remove(temp.size() - 1);
        func(i+1, target, arr, temp, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        func(0, target, candidates, new ArrayList<>(), list);
        return list;
    }
}