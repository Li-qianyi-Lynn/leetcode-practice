class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxIsland = 0;
        for (int i = 0; i < rows; i++) {
            int temp = 0;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    temp = dfs(grid, i, j);
                    maxIsland = Math.max(temp, maxIsland);

                }

            }

        }
        return maxIsland;

    }
    private int dfs(int[][] grid, int i, int j) {
        int area = 0;
        if (i < 0 || i >= grid.length || j < 0 || j >=grid[0].length || grid[i][j] == 0) {
            return area;

        }

        grid[i][j] = 0;
        area++;
        area += dfs(grid, i+1, j); //down
        area += dfs(grid, i, j+1); //right
        area += dfs(grid, i-1, j); //up
        area += dfs(grid, i, j-1); //left
        
        return area;
    }
}