class Solution:
    def pacificAtlantic(self, heights: list[list[int]]) -> list[list[int]]:
        dires = [(0,1),(1,0),(0,-1),(-1,0)]
        m,n = len(heights), len(heights[0])
        paci = set()
        atlan = set()
        res = []
        def dfs(r,c,visited):
            visited.add((r,c))
            for i,j in dires:
                x = i + r
                y = j + c
                if 0<=x<m and 0<=y<n and (x,y)not in visited and heights[x][y] >= heights[r][c]:
                    dfs(x,y, visited)
        

        for r in range(m):
            dfs(r,0,paci)
            dfs(r,n-1,atlan)
        
        for c in range(n):
            dfs(0,c,paci)
            dfs(m-1,c,atlan)
        
        for p in paci & atlan:
            res.append([p[0],p[1]])
        return res
        
