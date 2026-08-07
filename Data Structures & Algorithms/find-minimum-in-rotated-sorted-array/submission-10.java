class Solution {
    public int findMin(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        int min = nums[0];
        while(lo<=hi) {
            if(nums[lo] < nums[hi]) {
                return Math.min(min, nums[lo]);
            }
            int mid = lo + (hi-lo)/2;
            min = Math.min(min, nums[mid]);
            if(nums[mid] >= nums[lo]) {
                lo=mid+1;
            } else {
                hi=mid-1;
            }

        }
        return min;
    }
}
