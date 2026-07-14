class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] freq = new int[26];
        for(char c : p.toCharArray()){
            freq[c-'a']++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while(right < s.length()){
            char c = s.charAt(right);
            if(freq[c - 'a'] > 0) count--;
            freq[c - 'a']--;
            right++;
            if(right - left == p.length()){
                if(count == 0) list.add(left);
                freq[s.charAt(left) - 'a']++;
                if(freq[s.charAt(left) - 'a'] > 0) count++;
                left++;
            }
        }
        return list;
    }
}