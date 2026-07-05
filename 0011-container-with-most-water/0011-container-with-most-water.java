class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
            int length = Math.min(height[left], height[right]);
            int width = right-left;
            ans = Math.max(ans, length*width);
            if(height[left] < height[right]) left++;
            else if(height[left] > height[right]) right--;
            else{
                left++;
                right--;
            }
        }
        return ans;
    }
}