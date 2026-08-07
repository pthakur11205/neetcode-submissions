class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> results = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            results.add(nums[i]);
        }
        if(results.size() != nums.length) {
            return true;
        }
        return false;
    }
}
