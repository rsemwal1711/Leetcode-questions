class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character key : map.keySet()){
            pq.add(key);
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            char c = pq.poll();
            for(int i=0;i<map.get(c);i++){
                ans.append(c);
            }
        }
        return ans.toString();
    }
}