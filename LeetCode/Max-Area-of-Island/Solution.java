class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int max = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curArea = dfs(grid, i, j);
                max = Math.max(max, curArea);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length 
        || col < 0 || col >= grid[0].length
        || grid[row][col] == 0) {
            return 0;

        }
        grid[row][col] = 0;
        int area = 1;
        // explore other directions by dfs and calculate the area
        area += dfs(grid, row+1, col); //down
        area += dfs(grid, row-1, col); // up
        area += dfs(grid, row, col+1); // right
        area += dfs(grid, row, col-1); // left
        return area;


    }

}