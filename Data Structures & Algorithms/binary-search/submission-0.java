class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(lo <= high) {
            mid = lo + (high-lo)/2;
            if(target < nums[mid]) {
                high = mid - 1;
            } else if(target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        } 
        return -1;
    }
}
