class Solution {
    private int R;
    private int C;
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {
        R = board.length;
        C = board[0].length;
        for(int r=0; r<R; r++) {
            capture(r, 0, board);
            capture(r, C-1, board);
        }
        for(int c=0; c<C; c++) {
            capture(0, c, board);
            capture(R-1, c, board);
        }
        for(int r=0; r < R; r++) {
            for(int c=0; c < C; c++) {
                if(board[r][c]=='O') board[r][c] = 'X';
                if(board[r][c]=='T') board[r][c] = 'O';
            }
        }
    }

    private void capture(int r, int c, char[][] board) {
        if(r<0 || r>=R || c<0 || c>=C || board[r][c] != 'O') return;
        board[r][c] = 'T';
        for(int[] dir: dirs) {
            int row = r+dir[0];
            int col = c+dir[1];
            capture(row, col, board);
        }
    }


}
