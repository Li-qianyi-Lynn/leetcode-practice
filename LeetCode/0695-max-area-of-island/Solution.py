class Solution:
    def maxAreaOfIsland(self, grid: list[list[int]]) -> int:
        dires = [(0,1),(0,-1),(1,0),(-1,0)]
        max_area = 0
        m = len(grid)
        n = len(grid[0])
        def dfs(i,j):
            
            grid[i][j] = 0
            area = 1
            for r,c in dires:
                x = r+i
                y = c+j
                if 0<=x<m and 0<=y<n and grid[x][y] == 1:
                    area += dfs(x,y)
            return area

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    max_area = max(max_area, dfs(i,j))
        return max_area
        