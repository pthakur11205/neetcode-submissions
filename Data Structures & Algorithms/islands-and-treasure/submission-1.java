class Solution {
    private int LAND = 2147483647;
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int r=0; r < ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(grid[r][c]==0) q.offer(new int[]{r,c});
            }
        }

        if(q.size()==0) return;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for(int[] dir: dirs) {
                int row = r+dir[0];
                int col = c+dir[1];
                if(row<0 || row >= ROWS || col<0 || col>=COLS || grid[row][col] != Integer.MAX_VALUE) continue;
                q.offer(new int[]{row, col});
                grid[row][col] = 1+grid[r][c];
            }
        }
    }

    
}
