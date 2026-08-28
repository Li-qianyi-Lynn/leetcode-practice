1class Solution {
2    public int[][] generateMatrix(int n) {
3        int[][] matrix = new int[n][n];
4        int top = 0;
5        int left = 0;
6        int bottom = n-1;
7        int right = n-1;
8        int num = 1;
9        int target = n * n;
10
11        while (num <= target) {
12            //top:left -> right
13            for (int i = left; i <= right; i++) {
14                matrix[top][i] = num++;
15
16            }
17            top++;
18
19            //right: up -> buttom
20            for (int i = top; i <= bottom; i++) {
21                matrix[i][right] = num++;
22            }
23            right--;
24
25            // bottom: right -> left
26
27            for (int i = right; i >= left; i--) {
28                matrix[bottom][i] = num++;
29
30            }
31            bottom--;
32
33
34            // left: bottom -> top
35             for (int i = bottom; i >= top; i--) {
36                matrix[i][left] = num++;
37
38            }
39            left++;
40
41
42        }
43        return matrix;
44
45        
46        
47
48        
49    }
50}