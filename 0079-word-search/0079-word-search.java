class Solution {
    public boolean search(int i, int j, int n, int m, StringBuilder temp, String word, boolean[][] vis, char[][] board){
        if(i < 0 || j < 0 || i >= n || j >= m) return false;
        if(vis[i][j]){
            return false;
        }

        if(board[i][j] != word.charAt(temp.length())) return false;

        temp.append(board[i][j]);
        vis[i][j] = true;
        
        if(word.length() == temp.length()){
            vis[i][j] = false;
            temp.deleteCharAt(temp.length() - 1);
            return true;
        }

        boolean up = search(i-1, j, n, m, temp, word, vis, board);
        boolean down = search(i+1, j, n, m, temp, word, vis, board);
        boolean left = search(i, j-1, n, m, temp, word, vis, board);
        boolean right = search(i, j+1, n, m, temp, word, vis, board);

        vis[i][j] = false;
        temp.deleteCharAt(temp.length() - 1);
        return up || down || left || right;
    }
    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word == null) return false;
        if (word.length() == 0)return true;

        int n = board.length;
        int m = board[0].length;
        if(word.length() > n*m) return false;

        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(search(i, j, n, m, new StringBuilder(), word, vis, board)){
                    return true;
                }
            }
        }
        return false;
    }
}