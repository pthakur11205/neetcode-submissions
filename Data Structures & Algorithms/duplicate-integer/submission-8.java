class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int num: nums) {
            numbers.add(num);
        }
        if(numbers.size() == nums.length) {
            return false;
        } else {
            return true;
        }
    }
}
