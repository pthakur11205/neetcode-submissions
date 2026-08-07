class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int lo = 0;
        int hi = rows*cols-1;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            int row = mid/cols;
            int col = mid%cols;
            if(matrix[row][col] > target) {
                hi = mid-1;
            } else if(matrix[row][col] < target) {
                lo=mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
}
