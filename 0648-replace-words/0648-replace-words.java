class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            boolean found = false;
            String word = "";
            int minLen = Integer.MAX_VALUE;
            for(String it : dictionary){
                int len = it.length();
                if(arr[i].length() < it.length()){
                    continue;
                }
                if(it.equals(arr[i].substring(0, len))){
                    if(it.length() < minLen){
                        word = it;
                        minLen = it.length();
                        found = true;
                    }
                }
            }
            if(!found){
                if(i != arr.length-1) sb.append(arr[i]).append(" ");
                else sb.append(arr[i]);
            }
            else{
                if(i != arr.length-1) sb.append(word).append(" ");
                else sb.append(word);
            }
        }
        return sb.toString();
    }
}