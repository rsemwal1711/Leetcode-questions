class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // int[] nums = arr; this will not work as it will make both nums and arr sorted

        int[] nums = Arrays.copyOf(arr, arr.length);

        Arrays.sort(nums);
        Map<Integer, Integer> mpp = new HashMap<>();
        int rank = 1;
        for(int i=0;i<nums.length;i++){
            if(mpp.containsKey(nums[i])) continue;
            else{
                mpp.put(nums[i], rank);
                rank++;
            }
        }
        for(int i=0;i<nums.length;i++){
            arr[i] = mpp.get(arr[i]);
        }
        return arr;
    }
}