class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int it : nums){
            mpp.put(it, mpp.getOrDefault(it, 0) + 1);
        }
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()){
            if(entry.getValue() == 1) sum += entry.getKey();
        }
        return sum;
    }
}