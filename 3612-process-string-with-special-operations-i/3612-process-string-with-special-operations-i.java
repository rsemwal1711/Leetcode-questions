class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder("");
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                result.append(c);
            }
            else if(c == '*' && !result.isEmpty()){
                result.deleteCharAt(result.length() - 1);
            }
            else if(c == '#'){
                result.append(result);
            }
            else if(c == '%'){
                result = result.reverse();
            }
        }
        return result.toString();
    }
}