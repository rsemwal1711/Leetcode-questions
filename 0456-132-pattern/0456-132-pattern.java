class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int second = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            int num = nums[i];
            if(num < second) return true;
            while(!st.isEmpty() && num > st.peek()){
                second = st.pop();
            }
            st.push(num);
        }
        return false;
    }
}