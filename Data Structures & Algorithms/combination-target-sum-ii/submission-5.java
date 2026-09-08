class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int i) {

        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target<0 || i>=candidates.length) return;

        cur.add(candidates[i]);
        dfs(candidates, target-candidates[i], res, cur, i+1);

        while(i < candidates.length-1 && candidates[i] == candidates[i+1]) {
            i++;
        }

        cur.remove(cur.size()-1);
        dfs(candidates, target, res, cur, i+1);
    }
}
