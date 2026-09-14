1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        // first row i=0, j++
6        for (int j = 1; j < n;j++) {
7            grid[0][j] = grid[0][j-1] + grid[0][j];
8        }
9        // first col j = 0,i++
10        for (int i = 1; i < m;i++) {
11            grid[i][0] = grid[i-1][0] + grid[i][0];
12        }
13
14        for (int i = 1; i< m; i++) {
15            for (int j = 1; j < n;j++) {
16                grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]);
17            }
18        }
19        return grid[m-1][n-1];
20
21        
22    }
23}
24
25/**
26input: int[][] grid:  non-negative numbers
27output: min sum of the path: int
28
29we can only have two choice when we move:
301. move right
312. move down
32
33grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j])
34
35grid[m-1][n-1];
36
371 2 3
384 5 6
39
401 3 6
415 5 6
42 */