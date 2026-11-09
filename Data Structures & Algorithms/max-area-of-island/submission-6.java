class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int r=0; r < grid.length; r++) {
            for(int c=0; c < grid[0].length; c++) {
                if(grid[r][c]==1) {
                    res = Math.max(res, dfs(grid, r, c));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col]==0) return 0;
        grid[row][col] = 0;
        return 1 + dfs(grid, row+1, col) + dfs(grid, row-1, col) + dfs(grid, row, col+1) + dfs(grid, row, col-1);
    }
}
