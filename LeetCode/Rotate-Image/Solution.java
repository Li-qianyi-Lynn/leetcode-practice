1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4        for (int i = 0; i < n/2; i++) { // 旋转的层数
5            for (int j = i; j < n-1-i; j++) { 
6                int temp = matrix[i][j];
7
8                matrix[i][j] = matrix[n-1-j][i];
9                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
10                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
11                matrix[j][n-1-i] = temp;
12
13            }
14
15        }
16
17        
18    }
19}
20
21/**
22
23！try
247，4，1
258，5，2
269，6，3
27
28镜像+ 翻转
29right up (j,n-1-i);
30right buttom(n-1-i, n-1-j)
31left buttom(n-1-j, i)
32
33四角旋转+块状分割
34
35（i，j）
36（j,n-1-i）
37n/2
38
39
40
41
42 */