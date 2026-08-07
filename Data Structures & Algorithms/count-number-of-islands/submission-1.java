class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == '1') {
                    res++;
                    flood(row, col, grid);
                }
            }
        }
        return res;
    }

    private void flood(int row, int col, char[][] grid) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        } else {
            grid[row][col] = '0';
            flood(row+1, col, grid);
            flood(row-1, col, grid);
            flood(row, col+1, grid);
            flood(row, col-1, grid);
        }
    }
}
