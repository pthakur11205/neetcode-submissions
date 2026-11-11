class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int R = grid.length;
        int C = grid[0].length;
        int fresh = 0;
        for(int r=0; r<R; r++) {
            for(int c=0; c < C; c++) {
                if(grid[r][c]==1) fresh++;
                if(grid[r][c]==2) q.offer(new int[]{r, c});
            }
        }

        int time = 0;
        while(fresh > 0 && !q.isEmpty()) {
            int len = q.size();
            for(int i=0; i < len; i++) {
                int[] cur = q.poll();
                for(int[] dir: dirs) {
                    int r = cur[0]+dir[0];
                    int c = cur[1]+dir[1];
                    if(r>=0 && r<R && c>=0 && c<C && grid[r][c]==1) {
                        q.offer(new int[]{r,c});
                        grid[r][c]=2;
                        fresh--;
                    }
                }
            }
            time++;
        }

        return (fresh==0) ? time: -1;
    }
}
