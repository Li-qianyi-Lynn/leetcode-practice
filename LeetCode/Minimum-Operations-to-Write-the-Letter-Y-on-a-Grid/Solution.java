1class Solution {
2    public int minimumOperationsToWriteY(int[][] grid) {
3        // 算符合y letter 的数字有哪些， not y letter 有哪些
4        int[] county = new int[3];
5        int[] countNy = new int[3];
6        int res = Integer.MAX_VALUE;
7        int n = grid.length;
8
9        for (int r = 0; r < n; r++) {
10            for (int c = 0; c < n; c++) {
11                if (isY(r, c, n)) { 
12                    county[grid[r][c]]++;
13                } else {
14                    countNy[grid[r][c]]++;
15                }
16            }
17        }
18
19        int totalY = county[0] + county[1] + county[2];
20        int totalNy = countNy[0] + countNy[1] + countNy[2];
21
22        // 算各个数字出现的次数 for loop 存起来
23
24        //res =（totaly - 需要改动的cell num） + （totalny - 需要改动的cell num） ;math.min 
25        // 如果两两配对，哪一种op 最少
26        for (int i = 0; i < 3; i++) { // y 有可能的数字
27            for (int j =0; j < 3; j++) { // non y
28                if (i == j) {
29                    continue;
30                }
31
32                int cur = (totalY - county[i]) + (totalNy - countNy[j]);
33                res = Math.min(cur, res);
34            }
35
36        }
37        
38        return res;
39        
40    }
41
42    private boolean isY(int row, int col, int n) {
43        int mid = n / 2;
44         // top left: r== c && row <= mid
45        if (row == col && row <= mid) {
46            return true;
47        }
48        
49        // top right: r+c = n-1 && row <=mid
50        if (row + col == n-1 && row <= mid) {
51            return true;
52        }
53
54         //vertical line: row > mid && col == mid
55        if (row > mid && col == mid) {
56            return true;
57        }
58
59        return false;
60        
61    }
62}
63
64/**
65
66
67
68
69
70 */