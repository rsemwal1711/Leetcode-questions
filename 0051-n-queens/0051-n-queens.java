class Solution {
    public boolean isSafe(int row, int col, int n, char[][] board){
        for(int i=row;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j<n;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public void func(int row, int n, char[][] board, List<List<String>> ans){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                String str = "";
                for(int j=0;j<n;j++){
                    str += board[i][j];
                }
                temp.add(str);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(row, col, n, board)){
                board[row][col] = 'Q';
                func(row+1, n, board, ans);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }
        List<List<String>> list = new ArrayList<>();
        func(0, n, board, list);
        return list;
    }
}