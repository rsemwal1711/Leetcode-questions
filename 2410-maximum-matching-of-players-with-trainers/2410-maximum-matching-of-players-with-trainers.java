class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int count = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int left = 0;
        int right = 0;
        int p = players.length;
        int t = trainers.length;
        while(left < p && right < t){
            if(players[left] <= trainers[right]){
                left++;
                right++;
                count++;
            }
            else if(players[left] > trainers[right]){
                right++;
            }
            else{
                left++;
            }
        }
        return count;
    }
}