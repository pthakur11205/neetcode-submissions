class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, target, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int target, int i, List<List<Integer>> res, List<Integer> cur) {
        if(target==0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target<0 || i >= nums.length) return;

        cur.add(nums[i]);
        backtrack(nums, target-nums[i], i, res, cur);

        cur.remove(cur.size()-1);
        backtrack(nums, target, i+1, res, cur);
    }
}
