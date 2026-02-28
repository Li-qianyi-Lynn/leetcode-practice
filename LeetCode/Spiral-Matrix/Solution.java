1class Solution {
2    public List<Integer> spiralOrder(int[][] matrix) {
3        List<Integer> res = new ArrayList<>();
4        int top = 0; //waiting to process
5        int bottom = matrix.length-1;
6        int left = 0;
7        int right = matrix[0].length-1;
8
9        while (top <= bottom && left <= right) {
10            // l -> r
11            for (int i = left; i <= right; i++) {
12                res.add(matrix[top][i]);
13            }
14            top++;
15
16            // up -> down
17            for (int i = top; i <= bottom; i++ ) {
18                res.add(matrix[i][right]);
19            }
20            right--;
21            if (top <= bottom) {
22                 // r -> l
23                for (int i = right; i >= left; i--) {
24                    res.add(matrix[bottom][i]);
25                }
26                bottom--;
27
28            }
29            if (left <= right) { // down -> up
30                for (int i = bottom; i >= top; i--) {
31                    res.add(matrix[i][left]);
32                }
33                left++;
34            }    
35
36        }
37        return res;
38
39
40        
41    }
42}