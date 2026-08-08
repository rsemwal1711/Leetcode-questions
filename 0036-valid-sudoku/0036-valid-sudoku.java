class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c] == '.') continue;
                int num = board[r][c] - '0';
                int boxIndexNumber = (r/3) * 3 + (c/3);
                if(row[r][num] || col[c][num] || box[boxIndexNumber][num]) return false;
                row[r][num] = true;
                col[c][num] = true;
                box[boxIndexNumber][num] = true;
            }
        }
        return true;
    }
}