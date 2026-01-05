1class Solution {
2    public int numDistinctIslands(int[][] grid) {
3        Set<String> set = new HashSet<>();
4        int rows = grid.length;
5        int cols = grid[0].length;
6
7        for (int row = 0; row < rows; row++) {
8            for (int col = 0; col < cols; col++) {
9                StringBuilder sb = new StringBuilder(); // cur shape
10                if (grid[row][col] == 1) {
11                    dfs(grid, row, col, sb, 's'); // start
12                    set.add(sb.toString());
13                }
14            }
15        }
16        return set.size();
17    }
18
19    private void dfs(int[][] grid, int row, int col, StringBuilder shape, char dir) {
20        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
21            return;
22        }
23        grid[row][col] = 0; // visited
24        shape.append(dir);
25
26        dfs(grid, row+1, col, shape, 'd'); 
27        dfs(grid, row-1, col, shape, 'u');
28        dfs(grid, row, col+1, shape, 'r');
29        dfs(grid, row, col-1, shape, 'l');
30        shape.append('b');
31
32    }
33
34}
35
36/**
371) 如何判断有多少个distinct islands： set.size()
382）如何判断岛屿一致：stringbuilder 
39    rules：
40    1）路径一样
41    2）开始，回溯的位置一样
42    
43
44
45
46 */