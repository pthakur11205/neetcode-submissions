class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
        int R = grid.length;
        int C = grid[0].length;
        for(int r=0; r < R; r++) {
            for(int c=0; c < C; c++) {
                if(grid[r][c]==0) {
                    q.add(new int[]{r, c});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            for(int[] dir: dirs) {
                int r = dir[0]+row;
                int c = dir[1]+col;
                if(r>=0 && r < R && c>=0 && c < C && grid[r][c]==Integer.MAX_VALUE) {
                    grid[r][c] = 1 + grid[row][col];
                    q.add(new int[]{r, c});
                }
            }
        }
    }
}
