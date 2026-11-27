class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> perms = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, boolean[] pick) {
        if(perms.size()==nums.length) {
            res.add(new ArrayList<>(perms));
            return;
        }
        for(int i=0; i < nums.length; i++) {
            if(!pick[i]) {
                perms.add(nums[i]);
                pick[i] = true;
                backtrack(nums, pick);
                pick[i] = false;
                perms.remove(perms.size()-1);
                
            }
        }
    }
}
