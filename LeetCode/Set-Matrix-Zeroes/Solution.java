1class Solution {
2    public void setZeroes(int[][] matrix) {
3       
4        boolean firstrow = false;
5        boolean firstcol = false;
6
7        int m = matrix.length; // rows
8        int n = matrix[0].length; // cols
9
10        // first row and col
11        for (int i = 0; i < m; i++) {
12            if (matrix[i][0] == 0) {
13                firstcol = true;
14            }
15        }
16        for (int i = 0; i < n; i++) {
17            if (matrix[0][i] == 0) {
18                firstrow = true;
19
20            }
21        }
22        // iterate other rows and cols
23        for (int i = 1; i < m; i++) {
24            for (int j = 1; j < n; j++) {
25                if (matrix[i][j] == 0) {
26                    matrix[i][0] = 0;
27                    matrix[0][j] = 0;
28                }
29
30            }
31
32        }
33
34        // if there are zeros in row1 and col1, mark internal cells as 0
35        for (int i = 1; i < m; i++) {
36            for (int j = 1; j < n; j++) {
37                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
38                    matrix[i][j] = 0;   
39                }
40            }
41        }
42
43        // check firt row and col
44        if (firstrow) {
45            for (int i = 0; i < n; i++) {
46                matrix[0][i] = 0;
47            }
48        }
49        if (firstcol) {
50            for (int i = 0; i < m; i++) {
51                matrix[i][0] = 0;
52
53            }
54
55        }
56
57
58
59
60        
61    }
62}
63/**
64use first row col to record the 0
65
66 */