class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = 0;
        for(int i=0; i < matrix.length; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][matrix[i].length-1]) {
                index = i;
                break;
            }
        }
        int lo = 0;
        int hi = matrix[index].length-1;
        while(lo <= hi) {
            int mid = lo+(hi-lo)/2;
            if(matrix[index][mid] < target) {
                lo = mid+1;
            } else if(matrix[index][mid] > target) {
                hi = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
