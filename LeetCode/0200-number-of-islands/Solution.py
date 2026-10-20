class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dires = [(0,1),(1,0),(0,-1),(-1,0)]
        def dfs( i, j):
            #base case
            if grid[i][j] == "0":
                return
            
            grid[i][j] = "0"
            for (r,c) in dires:
                x = r+i
                y = c+j
                if x>= 0 and x < m and y >= 0 and y < n and grid[x][y] == "1":
                    dfs(x,y)


        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    res += 1
                    dfs(i,j)
        return res

        

        