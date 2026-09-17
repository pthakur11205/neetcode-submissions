class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int R = grid.length;
        int C = grid[0].length;
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(grid[r][c]==0) q.offer(new int[]{r,c});
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for(int[] dir: dirs) {
                int row = r+dir[0];
                int col = c+dir[1];
                if(row>=0 && row < R && col >=0 && col < C && grid[row][col] == Integer.MAX_VALUE) {
                    q.offer(new int[]{row, col});
                    grid[row][col] = 1 + grid[r][c];
                }
            }
        }

    }
}
