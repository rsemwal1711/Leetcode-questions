class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mpp = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(freq[i]).append("$");
            }
            String res = sb.toString();
            if(mpp.containsKey(res)){
                mpp.get(res).add(s);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                mpp.put(res, list);
            }
        }
        return new ArrayList<>(mpp.values());
    }
}