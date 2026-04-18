class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        ROWS, COLS = len(maze), len(maze[0])
        r,c = entrance
        queue = deque([(r,c,0)])
        visited = set([(r,c)])
        
        while queue:
            r,c,d = queue.popleft()
            
            if d != 0 and (r + 1 == ROWS or r - 1 == -1 or c + 1 == COLS or c - 1 == -1):
                return d
            
            for dr,dc in [(0,1),(1,0),(0,-1),(-1,0)]:
                nr,nc = r+dr, c+dc
                
                if ROWS > nr >= 0 <= nc < COLS and maze[nr][nc] != '+' and (nr,nc) not in visited:
                    visited.add((nr,nc))
                    queue.append((nr,nc,d+1))
        
        return -1