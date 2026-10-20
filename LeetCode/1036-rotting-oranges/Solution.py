from collections import deque
class Solution:
    def orangesRotting(self, grid: list[list[int]]) -> int:
        dires = [(0,1),(1,0),(0,-1),(-1,0)]
        queue = deque()
        m = len(grid)
        n = len(grid[0])
        mins = 0
        fresh = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    fresh+=1
        
        while queue and fresh > 0:
            size = len(queue)
            for s in range(size):
                i,j = queue.popleft()
                for r, c in dires:
                    x = r + i
                    y = c + j
                    if 0<=x<m and 0 <=y<n and grid[x][y] == 1:
                        queue.append((x,y))
                        grid[x][y] = 2
                        fresh -= 1
            mins+=1
        return mins if fresh == 0 else -1


        