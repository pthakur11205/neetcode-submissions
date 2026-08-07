class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for(int num: nums) {
            uniques.add(num);
        }
        if(uniques.size() < nums.length) {
            return true;
        }
        return false;
    }
}
