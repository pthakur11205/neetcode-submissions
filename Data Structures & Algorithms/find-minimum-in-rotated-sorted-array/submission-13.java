class Solution {
    public int findMin(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        int r = nums[0];
        while(lo<=hi) {
            if(nums[lo] < nums[hi]) {
                return Math.min(nums[lo], r);
            }

            int mid = lo+(hi-lo)/2;
            r = Math.min(nums[mid], r);
            if(nums[mid] < nums[lo]) {
                hi = mid-1;
            } else {
                lo=mid+1;
            }
        }
        return r;
    }
}
