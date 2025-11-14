class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        R, C = len(mat), len(mat[0])
        res = [[-1] * C for _ in range(R)]
        queue = deque()
        for r,c in product(range(R), range(C)):
            if mat[r][c] == 0:
                res[r][c] = 0
                queue.append((r,c))
        while queue:
            r,c = queue.popleft()
            for dr,dc in [(0,1),(1,0),(0,-1),(-1,0)]:
                nr,nc = r+dr, c+dc
                if R > nr >= 0 <= nc < C and mat[nr][nc] == 1 and res[nr][nc] == -1:
                    res[nr][nc] = res[r][c] + 1
                    queue.append((nr,nc))
        return res