class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(n, 0);
    }

    private int dfs(int n, int i) {
        if(i>=n) return (i==n) ? 1: 0;
        if(memo[i] != -1) return memo[i];
        memo[i] = dfs(n, i+1) + dfs(n, i+2);
        return memo[i];
    }
}
