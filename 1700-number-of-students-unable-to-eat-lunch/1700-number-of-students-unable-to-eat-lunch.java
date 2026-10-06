class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<students.length;i++){
            q.add(i);
        }
        int i = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            if(students[q.peek()] != sandwiches[i]){
                q.add(q.poll());
                cnt++;
                if(cnt == q.size()) return q.size();
            }
            else{
                cnt = 0;
                i++;
                q.poll();
            }
        }
        return q.size();
    }
}