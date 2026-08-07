class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> superMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if(superMap.containsKey(diff)) {
                return new int[] {superMap.get(diff), i};
            }

            superMap.put(num, i);
        }
        return new int[2];
    }
}
