class Solution {
    public int climbStairs(int n) {
        return dfs(0, n);
    }

    private int dfs(int i, int n) {
        if(i >= n) {
            if(i==n) return 1;
            return 0;
        }

        return dfs(i+1, n) + dfs(i+2, n);
    }
}
