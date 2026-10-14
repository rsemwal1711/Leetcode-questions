class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();

        if(sum > 9 * num) return "";

        for(int i=0;i<num;i++){
            if(sum == 0){
                ans.append('0');
            }
            else if(sum < 10){
                ans.append(sum);
                sum = 0;
            }
            else{
                ans.append(9);
                sum -= 9;
            }
        }
        return sum == 0 ? ans.toString() : "";
    }
}