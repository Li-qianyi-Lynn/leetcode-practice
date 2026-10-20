class Solution:
    def orangesRotting(self, grid: list[list[int]]) -> int:
        """
        queue: rotten orange (i,j)
        1. for loop: rotten orange, fresh orange (bfs -=1)-> edge case
        2. bfs: size
        

        return fresh orange (bfs -=1)
        """
        dires = [(0,1),(1,0),(0,-1),(-1,0)]
        queue = deque()
        fresh = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh +=1
                elif grid[i][j] == 2:
                    queue.append((i,j,0))
        if fresh == 0:
            return 0
        
        while queue:
            size = len(queue)
            for _ in range(size):
                i,j,step = queue.popleft()
                for r,c in dires:
                    x = r+i
                    y = c+j
                    if 0<=x <m and 0<=y<n and grid[x][y] == 1:
                        fresh-=1
                        if fresh == 0:
                            return step+1
                        grid[x][y] = 2
                        queue.append((x,y,step+1))
        
        return -1


        