class Pair{
    String word;
    int cnt;
    Pair(String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String str = p.word;
            int count = p.cnt;
            if(str.equals(endWord)) return count;
            for(int i=0;i<str.length();i++){
                for(char c='a';c<='z';c++){
                    char[] arr = str.toCharArray();
                    arr[i] = c;
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, count+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}