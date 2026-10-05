class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int res = dfs(amount, coins);
        return (res == Integer.MAX_VALUE) ? -1: res;
    }

    private int dfs(int amt, int[] coins) {
        if(amt==0) return 0;
        if(memo.containsKey(amt)) return memo.get(amt);
        int res = Integer.MAX_VALUE;
        for(int coin: coins) {
            if(amt-coin >= 0) {
                int result = dfs(amt-coin, coins);
                if(result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }
        memo.put(amt, res);
        return res;
    }
}
