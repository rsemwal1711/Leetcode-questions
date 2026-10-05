class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        for(int i=0;i<tickets.length;i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int person = q.peek();
            tickets[person]--;
            time++;
            if(person == k){
                if(tickets[person] == 0){
                    break;
                }
                else{
                    q.add(q.poll());
                }
            }
            else{
                if(tickets[person] == 0) {
                    q.poll();
                }
                else{
                    q.add(q.poll());
                }
            }
        }
        return time;
    }
}