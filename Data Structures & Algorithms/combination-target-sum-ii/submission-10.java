class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int i, List<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0 || i >= candidates.length) return;

        cur.add(candidates[i]);
        backtrack(candidates, target-candidates[i], i+1, cur);
        

        while(i < candidates.length-1 && candidates[i] == candidates[i+1]) i++;

        cur.remove(cur.size()-1);
        backtrack(candidates, target, i+1,cur);


    }
}
