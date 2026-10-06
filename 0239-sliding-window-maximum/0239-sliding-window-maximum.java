class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peekFirst() <= i-k){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]){
                q.pollLast();
            }
            q.addLast(i);
            if(i >= k-1) ans[i-k+1] = nums[q.peekFirst()];
        }
        return ans;
    }
}