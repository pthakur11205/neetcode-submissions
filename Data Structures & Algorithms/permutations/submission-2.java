class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, boolean[] pick, List<Integer> perms) {
        if(perms.size() == nums.length) {
            res.add(new ArrayList<>(perms));
            return;
        }

        for(int i=0; i < nums.length; i++) {
            if(!pick[i]) {
                perms.add(nums[i]);
                pick[i] = true;
                backtrack(nums, res, pick, perms);
                perms.remove(perms.size()-1);
                pick[i] = false;
            }
        }
    }
}
