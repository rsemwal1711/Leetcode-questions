class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> str = new Stack<>();

        String current = "";
        int number = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                number = (number * 10) + (c - '0');
            }
            else if(c == '['){
                nums.push(number);
                str.push(current);
                number = 0;
                current = "";
            }
            else if(c == ']'){
                int n = nums.pop();
                String prev = str.pop();
                String temp = prev;
                for(int i=0;i<n;i++){
                    temp += current;
                }
                current = temp;
            }
            else{
                current += c;
            }
        }
        return current;
    }
}