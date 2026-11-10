class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int R = grid.length;
        int C = grid[0].length;
        for(int r=0; r < R; r++) {
            for(int c=0; c < C; c++) {
                if(grid[r][c]==0) q.offer(new int[]{r, c});
            }
        }

        if(q.isEmpty()) return;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            for(int[] dir: dirs) {
                int r = row+dir[0];
                int c = col+dir[1];
                if(r >= 0 && r < R && c >= 0 && c < C && grid[r][c]==Integer.MAX_VALUE) {
                    q.offer(new int[]{r, c});
                    grid[r][c] = 1 + grid[row][col];
                }
            }
        }

       
    }
}
