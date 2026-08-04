class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int mini = nums[0];
        int maxi = nums[nums.length-1];
        List<Integer> list = new ArrayList<>();
        for(int i=mini;i<=maxi;i++){
            list.add(i);
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) list.remove(Integer.valueOf(nums[i]));
        }
        return list;
    }
}