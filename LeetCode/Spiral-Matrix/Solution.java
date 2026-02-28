1public class Solution {
2    public List<Integer> spiralOrder(int[][] matrix) {
3        List<Integer> res = new ArrayList<>();
4        int left = 0, right = matrix[0].length;
5        int top = 0, bottom = matrix.length;
6
7        while (left < right && top < bottom) {
8            for (int i = left; i < right; i++) {
9                res.add(matrix[top][i]);
10            }
11            top++;
12            for (int i = top; i < bottom; i++) {
13                res.add(matrix[i][right - 1]);
14            }
15            right--;
16            if (!(left < right && top < bottom)) {
17                break;
18            }
19            for (int i = right - 1; i >= left; i--) {
20                res.add(matrix[bottom - 1][i]);
21            }
22            bottom--;
23            for (int i = bottom - 1; i >= top; i--) {
24                res.add(matrix[i][left]);
25            }
26            left++;
27        }
28
29        return res;
30    }
31}