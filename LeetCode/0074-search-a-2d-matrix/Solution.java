class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = rows * cols -1;
        int l = 0;
        while (l <= r) {
            int mid = l + (r-l)/2;
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] < target) {
                l = mid+1;

            } else if (matrix[row][col] > target) {
                r = mid -1;

            } else {
                return true;
            }
        }
        return false;
        
    }
}