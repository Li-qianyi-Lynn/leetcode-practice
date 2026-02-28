1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4        for (int i = 0; i < n/2; i++) { // 旋转的层数
5            for (int j = i; j < n-1-i; j++) {
6                int temp = matrix[i][j];
7// right up (j,n-1-i);
8// right buttom(n-1-i, n-1-j)
9// left buttom(n-1-j, i)
10                matrix[i][j] = matrix[n-1-j][i];
11                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
12                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
13                matrix[j][n-1-i] = temp;
14
15
16
17
18            }
19
20        }
21
22        
23    }
24}
25
26/**
27
28！try
297，4，1
308，5，2
319，6，3
32
33
34四角旋转+块状分割
35
36（i，j）
37（j,n-1-i）
38n/2
39
40
41
42
43 */