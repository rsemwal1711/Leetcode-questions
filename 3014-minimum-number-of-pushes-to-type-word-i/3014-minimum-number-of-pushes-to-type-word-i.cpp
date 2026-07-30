class Solution {
public:
    int minimumPushes(string word) {
        int n = word.length();
        if(n <= 8) return n;
        int sum = 8;
        int len = 9;
        int i = 2;
        while(len <= n){
            sum += i;
            if(len % 8 == 0){
                i++;
            } 
            len++;
        }
        return sum;
    }
};