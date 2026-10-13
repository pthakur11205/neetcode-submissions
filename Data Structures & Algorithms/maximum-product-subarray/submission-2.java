class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;
        for(int n: nums) {
            int num = n*curMax;
            curMax = Math.max(Math.max(num, n), n*curMin);
            curMin = Math.min(Math.min(num, n), n*curMin);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
