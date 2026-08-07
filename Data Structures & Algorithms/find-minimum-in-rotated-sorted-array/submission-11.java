class Solution {
    public int findMin(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        int res = nums[0];
        while(lo<=hi) {
            if(nums[lo] < nums[hi]) {
                return Math.min(res, nums[lo]);
            }
            int mid = lo + (hi-lo)/2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] < nums[lo]) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return res;
    }
}
