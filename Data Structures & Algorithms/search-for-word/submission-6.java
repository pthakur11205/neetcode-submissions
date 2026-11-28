class Solution {
    private int R, C;
    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = board[0].length;
        for(int r=0; r < R; r++) {
            for(int c=0; c < C; c++) {
                if(dfs(word, board, r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(String word, char[][] board, int r, int c, int i) {
        if(i==word.length()) return true;
        if(r<0 || r >= R || c<0 || c>=C || board[r][c] == '#' || board[r][c] != word.charAt(i)) return false;

        board[r][c] = '#';
        boolean res = dfs(word, board, r+1, c, i+1) || dfs(word, board, r-1, c, i+1) || dfs(word, board, r, c+1, i+1) || dfs(word, board, r, c-1, i+1);
        board[r][c] = word.charAt(i);
        return res;

    }
}
