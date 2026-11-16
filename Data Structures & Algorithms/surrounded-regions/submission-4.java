class Solution {
    private int R, C;
    public void solve(char[][] board) {
        R = board.length;
        C = board[0].length;
        for(int r=0; r < R; r++) {
            if(board[r][0] == 'O') capture(r, 0, board);
            if(board[r][C-1] == 'O') capture(r, C-1, board);
        }

        for(int c=0; c < C; c++) {
            if(board[0][c] == 'O') capture(0, c, board);
            if(board[R-1][c] == 'O') capture(R-1, c, board);
        }

        for(int r=0; r < R; r++) {
            for(int c=0; c<C; c++) {
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }

    private void capture(int r, int c, char[][] board) {
        if(r < 0 || r>=R || c < 0 || c>=C || board[r][c] != 'O') return;
        board[r][c] = 'T';
        capture(r+1, c, board);
        capture(r-1, c, board);
        capture(r, c+1, board);
        capture(r, c-1, board);
    }
}
