class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> cur, int i) {

        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0 || i >= nums.length) return;

        cur.add(nums[i]);
        dfs(nums, target-nums[i], res, cur, i);

        cur.remove(cur.size()-1);
        dfs(nums, target, res, cur, i+1);
    }
}
