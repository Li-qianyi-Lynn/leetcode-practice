1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4  
5
6        for (int i = 0; i < (n / 2); i++) { // 外部圈层
7            for (int j = i; j <(n - 1-i); j++) {
8                int temp = matrix[i][j];
9
10                matrix[i][j] = matrix[n-1-j][i];
11                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
12                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
13                matrix[j][n-1-i] = temp;
14
15            }
16
17        } 
18    
19    }
20}