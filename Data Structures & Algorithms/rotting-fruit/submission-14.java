class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int R = grid.length;
        int C = grid[0].length;
        for(int r=0; r < R; r++) {
            for(int c=0; c < C; c++) {
                if(grid[r][c] == 2) q.offer(new int[]{r,c});
                if(grid[r][c] == 1) fresh++;
            }
        }

        
        int res = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(fresh>0 && !q.isEmpty()) {
            int len = q.size();
            for(int i=0; i < len; i++) {
                int[] cur = q.poll();
                for(int[] dir: dirs) {
                    int row = cur[0]+dir[0];
                    int col = cur[1]+dir[1];
                    if(row >= 0 && row < R && col >= 0 && col < C && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        fresh--;
                        q.offer(new int[]{row, col});
                    }
                }
            }
            res++;
        }

        return (fresh==0) ? res: -1;
    }
}
