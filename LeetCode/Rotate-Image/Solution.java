1public class Solution {
2    public void rotate(int[][] matrix) {
3        // Reverse the matrix vertically
4        reverse(matrix);
5
6        // Transpose the matrix
7        for (int i = 0; i < matrix.length; i++) {
8            for (int j = i; j < matrix[i].length; j++) {
9                int temp = matrix[i][j];
10                matrix[i][j] = matrix[j][i];
11                matrix[j][i] = temp;
12            }
13        }
14    }
15
16    private void reverse(int[][] matrix) {
17        int n = matrix.length;
18        for (int i = 0; i < n / 2; i++) {
19            int[] temp = matrix[i];
20            matrix[i] = matrix[n - 1 - i];
21            matrix[n - 1 - i] = temp;
22        }
23    }
24}