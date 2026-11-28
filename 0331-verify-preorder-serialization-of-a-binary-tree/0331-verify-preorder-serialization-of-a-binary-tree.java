class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int slot = 1;
        for(String a : arr){
            if(slot == 0) return false;
            if(a.equals("#")){
                slot--;
            }
            else{
                slot++;
            }
        }
        return slot == 0;
    }
}