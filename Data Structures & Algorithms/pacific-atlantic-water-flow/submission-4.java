class Solution {
    private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int R;
    private int C;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        R = heights.length;
        C = heights[0].length;
        boolean[][] pac = new boolean[R][C];
        boolean[][] atl = new boolean[R][C];
        List<List<Integer>> res = new ArrayList<>();
        for(int r=0; r<R; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, C-1, atl, heights);
        }
        for(int c=0; c<C;c++) {
            dfs(0, c, pac, heights);
            dfs(R-1, c, atl, heights);
        }
        for(int r=0; r < R; r++) {
            for(int c=0; c < C; c++) {
                if(pac[r][c] && atl[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] board, int[][] heights) {
        board[r][c] = true;
        for(int[] dir: dirs) {
            int newRow = r+dir[0];
            int newCol = c+dir[1];
            if(newRow >= 0 && newRow < R && newCol>=0 && newCol<C && !board[newRow][newCol] && heights[newRow][newCol] >= heights[r][c]) {
                dfs(newRow, newCol, board, heights);
            }
        }
    }
}
