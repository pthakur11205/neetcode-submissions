class Solution {
    private int[] memo;
    public int climbStairs(int n) {
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(0, n);
    }

    private int dfs(int i, int n) {
        if(i >= n) {
            if(i==n) return 1;
            return 0;
        }

        if(memo[i] != -1) return memo[i];

        memo[i] = dfs(i+1, n) + dfs(i+2, n);
        return memo[i];
    }
}
