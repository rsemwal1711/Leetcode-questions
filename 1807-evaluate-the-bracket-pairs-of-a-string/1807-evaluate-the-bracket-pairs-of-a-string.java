class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        for(List<String> kn : knowledge){
            String key = kn.get(0);
            String value = kn.get(1);
            map.put(key, value);
        }
        int i=0;
        int n = s.length();
        while(i < n){
            char c = s.charAt(i);
            if(c == '('){
                StringBuilder match = new StringBuilder();
                i++;
                boolean found = false;
                while(i < n && s.charAt(i) != ')'){
                    found = true;
                    match.append(s.charAt(i));
                    i++;
                }
                if(map.containsKey(match.toString())) ans.append(map.get(match.toString()));
                else ans.append("?");
                if(found) i++;
            }
            else{
                ans.append(c);
                i++;
            }
        }
        return ans.toString();
    }
}