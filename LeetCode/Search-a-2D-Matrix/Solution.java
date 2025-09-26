class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = rows * cols - 1;
        int l = 0;
        while (l <= r) {
            int m = l + (r-l) / 2;
            int row = m / cols;
            int col = m % cols;

            if (target < matrix[row][col]) {
                r = m -1;


            } else if (target > matrix[row][col]) {
                l = m +1;

            } else {
                return true;
            }

        }
        return false;
    }
}