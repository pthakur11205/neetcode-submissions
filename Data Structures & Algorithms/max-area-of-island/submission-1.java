class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, calcArea(i, j, grid));
                }
            }
        }
        return max;
    }

    private int calcArea(int row, int col, int[][] grid) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        } else {
            grid[row][col] = 0;
            return 1 + calcArea(row-1, col, grid) + calcArea(row+1, col, grid) + calcArea(row, col-1, grid) + calcArea(row, col+1, grid);
        }
    }
}
