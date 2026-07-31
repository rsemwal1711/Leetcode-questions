class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> mpp = new TreeMap<>();
        for(char c : word.toCharArray()){
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int it : mpp.values()){
            list.add(it);
        }
        Collections.sort(list, Collections.reverseOrder());
        int ans = 0;
        int i=0;
        int a = 1;
        while(i < list.size()){
            int temp = i;
            while(i < list.size() && i < temp+8){
                ans += list.get(i)*a;
                i++;
            }
            a += 1;
        }
        return ans;
    }
}