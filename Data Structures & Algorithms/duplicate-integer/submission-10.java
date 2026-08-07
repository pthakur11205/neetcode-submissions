class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> superman = new HashSet<>();
        for(int num: nums) {
            superman.add(num);
        }
        if(superman.size() != nums.length) {
            return true;
        }
        return false;
    }
}