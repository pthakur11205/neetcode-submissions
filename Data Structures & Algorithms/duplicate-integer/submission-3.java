class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> superset = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            superset.add(nums[i]);
        }
        if(superset.size() != nums.length) {
            return true;
        } else {
            return false;
        }
    }
}
