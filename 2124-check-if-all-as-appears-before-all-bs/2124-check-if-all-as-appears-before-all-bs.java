class Solution {
    public boolean checkString(String s) {
        boolean a = false;
        boolean b = false;
        for(char c : s.toCharArray()){
            if(c == 'a'){
                if(b){
                    return false;
                }
                else{
                    a = true;
                }
            }
            else b = true;
        }
        return true;
    }
}