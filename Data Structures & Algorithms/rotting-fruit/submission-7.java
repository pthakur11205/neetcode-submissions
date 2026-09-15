class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == 1) fresh++;
                if(grid[r][c] == 2) q.offer(new int[]{r, c});
            }
        }

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while(fresh > 0 && !q.isEmpty()) {
            int len = q.size();
            for(int i=0; i < len; i++) {
                int[] rotten = q.poll();
                for(int[] dir: dirs) {
                    int row = rotten[0] + dir[0];
                    int col = rotten[1] + dir[1];
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }

                }
            }
            time++;
        }

        return (fresh==0) ? time : -1;
    }
}
