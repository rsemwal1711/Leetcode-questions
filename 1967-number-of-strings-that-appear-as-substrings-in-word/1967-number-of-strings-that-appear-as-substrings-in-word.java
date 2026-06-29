class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String it : patterns){
            if(word.contains(it)) count++;
        }
        return count;
    }
}