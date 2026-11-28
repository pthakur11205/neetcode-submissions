class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int i) {
        if(i>=nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums, i+1);
        subset.remove(subset.size()-1);
        while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
        backtrack(nums, i+1);
    }
}
