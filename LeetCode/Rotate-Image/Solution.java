1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4
5        //transpose [i,j] ->[j,i]
6        for (int i = 0; i < n; i++) {
7            for (int j = i; j < n; j++) {
8                int temp = matrix[i][j];
9                matrix[i][j] = matrix[j][i];
10                matrix[j][i] = temp;
11
12            }
13        }
14
15        // reverse [j,i] -> [j,n-1-i]
16
17         for (int i = 0; i < n; i++) {
18            for (int j = 0; j < n / 2; j++) {
19                int tmp = matrix[i][j];
20                matrix[i][j] = matrix[i][n - j - 1];
21                matrix[i][n - j - 1] = tmp;
22            }
23        }
24    }
25}
26
27/**
28
29！try
307，4，1
318，5，2
329，6，3
33i: levels; [0,n/2)
34j: cell; [i, n-1-i)
35 [1, 4, 7], 
36 [2, 5, 8],    
37 [3, 6, 9]
38
39 
40
41left-up: [i,j]
42right-up:[i,n-1-i]
43left-down
44right-down
45
46镜像+ 翻转
47right up (j,n-1-i);
48right buttom(n-1-i, n-1-j)
49left buttom(n-1-j, i)
50
51四角旋转+块状分割
52
53（i，j）
54（j,n-1-i）
55n/2
56
57
58
59
60 */