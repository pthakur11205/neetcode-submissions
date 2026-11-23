class Solution {
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int R, C;
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
        grid[r][c] = true;
        for(int[] dir: dirs) {
            int nR = r+dir[0];
            int nC = c+dir[1];
            if(nR>=0 && nR<R && nC>=0 && nC<C && !grid[nR][nC] && heights[nR][nC] >= heights[r][c]) {
                dfs(nR, nC, grid, heights);
            }
        }
    }
}
