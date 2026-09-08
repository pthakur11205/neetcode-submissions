class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> subset, int i) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, res, subset, i+1);

        while(i < nums.length-1 && nums[i] == nums[i+1]) {
            i++;
        }

        subset.remove(subset.size()-1);
        backtrack(nums, res, subset, i+1);

        
    }
}
