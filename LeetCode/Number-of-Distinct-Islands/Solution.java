1class Solution {
2    public int numDistinctIslands(int[][] grid) {
3      Set<String> shapes = new HashSet<>();
4      int row = grid.length;
5      int col = grid[0].length;
6
7      for (int i = 0; i < row; i++) {
8        for (int j = 0; j < col; j++) {
9            if (grid[i][j] == 1) {
10                StringBuilder currentShape = new StringBuilder();
11                dfs(grid, i, j, currentShape, 'o');
12                shapes.add(currentShape.toString());
13            }
14        }
15      }  
16      return shapes.size();
17    }
18
19    private void dfs(int[][] grid, int i, int j, StringBuilder currentShape, char dir) {
20        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
21
22        grid[i][j] = 2;
23        currentShape.append(dir);
24
25        dfs(grid, i, j - 1, currentShape, 'l');
26        dfs(grid, i + 1, j, currentShape, 'd');
27        dfs(grid, i, j + 1, currentShape, 'r');
28        dfs(grid, i - 1, j, currentShape, 'u');
29
30        currentShape.append('b');
31    }
32}
33