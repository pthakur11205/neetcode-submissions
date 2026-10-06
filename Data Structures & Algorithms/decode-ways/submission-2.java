class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return dfs(s, dp, 0);
    }

    private int dfs(String s, Map<Integer, Integer> dp, int i) {
        if(dp.containsKey(i)) return dp.get(i);
        if(s.charAt(i) == '0') return 0;
        int res = dfs(s, dp, i+1);
        if((i+1 < s.length()) && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))) {
            res += dfs(s, dp, i+2);
        }
        dp.put(i, res);
        return res;
    }
}
