class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int same = 0;
        int smaller = 0;
        for(int num : nums){
            if(num < target) smaller++;
            else if(num == target) same++;
        }
        for(int i=0;i<same;i++){
            list.add(smaller + i);
        }
        return list;
    }
}