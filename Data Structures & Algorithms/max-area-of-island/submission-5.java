class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int r=0; r < grid.length; r++) {
            for(int c=0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    res = Math.max(res, dfs(r, c, grid));
                }
            }
        }
        return res;
    }

    private int dfs(int r, int c, int[][] grid) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;

        return 1 + dfs(r+1, c, grid) + dfs(r-1, c, grid) + dfs(r, c+1, grid) + dfs(r, c-1, grid);
    }
}
