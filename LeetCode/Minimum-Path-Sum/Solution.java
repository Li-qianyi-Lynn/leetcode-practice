1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        for (int j = 1; j < n; j++) {
6            grid[0][j] += grid[0][j-1];
7
8        }
9        for (int i = 1; i < m; i++) {
10            grid[i][0] += grid[i-1][0];
11
12        }
13
14        for (int i = 1; i < m; i++) {
15            for (int j = 1; j < n; j++) {     
16                grid[i][j] = Math.min((grid[i][j-1] + grid[i][j]),grid[i-1][j] + grid[i][j]);
17            }
18        }
19        return grid[m-1][n-1];
20    }
21}
22/**
23dp[i][j]: the min sum along its path
24
25init: first row, first col
26build dp dp[i][j] = min ((dp[i][j-1] + grid[i][j]),dp[i-1][j] + grid[i][j])
27
28
29
30 */