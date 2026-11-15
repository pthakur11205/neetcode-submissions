class Solution {
    private int R, C;

    public void solve(char[][] board) {
        R = board.length;
        C = board[0].length;
        for(int r=0; r < R; r++) {
            if(board[r][0]=='O') capture(board, r, 0);
            if(board[r][C-1]=='O') capture(board, r, C-1);
        }

        for(int c=0; c < C; c++) {
            if(board[0][c] == 'O') capture(board, 0, c);
            if(board[R-1][c] == 'O') capture(board, R-1, c);
        }

        for(int r=0; r < R; r++) {
            for(int c=0; c < C; c++) {
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }

    private void capture(char[][] board, int r, int c) {
        if(r<0 || r>=R || c<0 || c>=C || board[r][c]!='O') return;
        board[r][c] = 'T';
        capture(board, r+1, c);
        capture(board, r-1, c);
        capture(board, r, c+1);
        capture(board, r, c-1);

    }
}
