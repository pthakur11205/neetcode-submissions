class Solution {
    
    public int numIslands(char[][] grid) {
        int res=0;
        for(int r=0; r < grid.length; r++) {
            for(int c=0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    dfs(c, r, grid);
                    res++;
                } 
            }
        }
        return res;
    }

    private void dfs(int col, int row, char[][] grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return;

        grid[row][col] = '0';
        dfs(col+1, row, grid);
        dfs(col-1, row, grid);
        dfs(col, row+1, grid);
        dfs(col, row-1, grid);
    }
}
