class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> superman = new HashSet<>();
        for(int i: nums) {
            superman.add(i);
        }
        if(nums.length != superman.size()) {
            return true;
        }
        return false;
    }
}
