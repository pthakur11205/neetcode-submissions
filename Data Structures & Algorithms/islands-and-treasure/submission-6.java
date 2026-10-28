class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int r=0; r < grid.length; r++) {
            for(int c=0; c < grid[0].length; c++) {
                if(grid[r][c] == 0) q.offer(new int[]{r, c});
            }
        }

        if(q.isEmpty()) return;

        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir: dirs) {
                int row = cur[0]+dir[0];
                int col = cur[1]+dir[1];
                if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == Integer.MAX_VALUE) {
                    q.offer(new int[]{row, col});
                    grid[row][col] = 1+grid[cur[0]][cur[1]];
                }
            }
        }
    }
}
