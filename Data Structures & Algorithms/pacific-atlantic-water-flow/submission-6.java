class Solution {
    private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int R;
    private int C;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        R = heights.length;
        C = heights[0].length;
        boolean[][] pac = new boolean[R][C];
        boolean[][] atl = new boolean[R][C];
        for(int r=0; r < R; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, C-1, atl, heights);
        }
        for(int c=0; c < C; c++) {
            dfs(0, c, pac, heights);
            dfs(R-1, c, atl, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int r=0; r < R; r++) {
            for(int c=0; c < C; c++) {
                if(pac[r][c] && atl[r][c]) res.add(Arrays.asList(r, c));
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] grid, int[][] heights) {
        if(r<0 || r>=R || c<0 || c>=C || grid[r][c]!=false) return;
        grid[r][c] = true;
        for(int[] dir: dirs) {
            int row = r + dir[0];
            int col = c + dir[1];
            if(row>=0 && row < R && col>=0 && col < C && heights[row][col] >= heights[r][c]) {
                dfs(row, col, grid, heights);
            }
        }
    }
}
