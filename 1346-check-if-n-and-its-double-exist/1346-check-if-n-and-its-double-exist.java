class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> st = new HashSet<>();
        for(int it : arr){
            if((st.contains(it*2)) || ((it%2 == 0) && (st.contains(it/2)))) return true;
            st.add(it);
        }
        return false;
    }
}