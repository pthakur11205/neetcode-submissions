class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, calcArea(row, col, grid));
                }
            }
        }
        return maxArea;
    }

    private int calcArea(int row, int col, int[][] grid) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        } else {
            grid[row][col] = 0;
            return 1 + calcArea(row+1, col, grid) + calcArea(row-1, col, grid) + calcArea(row, col-1, grid) + calcArea(row, col+1, grid);
        }
    }
}
