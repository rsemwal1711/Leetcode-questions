class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1 = 0;
        int el2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int it : nums){
            if(count1 > 0 && it == el1) count1++;
            else if(count2 > 0 && it == el2) count2++;
            else if(count1 == 0){
                count1 = 1;
                el1 = it;
            }
            else if(count2 == 0){
                count2 = 1;
                el2 = it;
            }
            else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1 = count2 = 0;
        for(int it : nums){
            if(it == el1) count1++;
            else if(it == el2) count2++;
        }
        if(count1 > nums.length/3) ans.add(el1);
        if(count2 > nums.length/3) ans.add(el2);
        return ans;
    }
}