class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(grid[r][c]==1) fresh++;
                if(grid[r][c]==2) q.offer(new int[]{r,c});
            }
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(fresh > 0 && !q.isEmpty()) {
            int length = q.size();
            for(int i=0; i<length; i++) {
                int[] cur = q.poll();
                for(int[] dir: dirs) {
                    int row = cur[0]+dir[0];
                    int col = cur[1]+dir[1];
                    if(row>=0 && row < ROWS && col>=0 && col<COLS && grid[row][col]==1) {
                        grid[row][col] = 2;
                        fresh--;
                        q.offer(new int[]{row, col});
                    }
                    
                }
            }
            time++;
        }

        return (fresh==0) ? time: -1;
    }
}
