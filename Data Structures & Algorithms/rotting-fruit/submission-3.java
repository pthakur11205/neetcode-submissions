class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int f = 0;
        int t = 0;

        for(int r=0; r < grid.length; r++) {
            for(int c=0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) f++;
                if(grid[r][c] == 2) q.offer(new int[]{r,c});
            }
        }

        int[][] dirs = {{0,1}, {0,-1}, {1, 0}, {-1,0}};
        while(f>0 && !q.isEmpty()) {
            int length = q.size();
            for(int i=0; i < length; i++) {
                int[] cur = q.poll();
                for(int[] dir: dirs) {
                    int row = cur[0]+dir[0];
                    int col = cur[1]+dir[1];
                    if(row>=0 && row < grid.length && col>=0 && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        f--;
                    }
                }
            }
            t++;
        }

        return (f==0) ? t: -1;
    }
}
