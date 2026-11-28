class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> perm = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, boolean[] pick) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0; i < nums.length; i++) {
            if(!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                backtrack(nums, pick);
                pick[i] = false;
                perm.remove(perm.size()-1);
            }
        }
    }
}
