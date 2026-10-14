class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin=1, curMax = 1;
        for(int n: nums) {
            int tmp = curMax*n;
            curMax = Math.max(Math.max(curMax*n, curMin*n), n);
            curMin = Math.min(Math.min(curMin*n, tmp), n);
            res = Math.max(curMax, res);
        }

        return res;
    }
}
