class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        def find(e):
            if e != parent[e]:                
                parent[e] = find(e := parent[e])
            return e

        def union(a, b):
            if (root_a := find(a)) != (root_b := find(b)):
                if size[root_a] < size[root_b]:
                    root_a, root_b = root_b, root_a
                size[root_a] += size[root_b]
                parent[root_b] = root_a
        
        R, C = len(grid), len(grid[0])
        N = R * C
        parent = list(range(N))
        size = [1] * N
        ones = 0
        for r,c in product(range(R), range(C)):
            if grid[r][c]:
                idx = r * C + c
                if r > 0 and grid[r - 1][c]: union(idx - C, idx)
                if c > 0 and grid[r][c - 1]: union(idx - 1, idx)
                ones += 1
        if N == ones:
            return ones
        max_size = 0
        for r,c in product(range(R), range(C)):
            if not grid[r][c]:
                current_max = 1
                used_roots = set()
                for nr,nc in [(r, c + 1),(r + 1, c),(r, c - 1),(r - 1, c)]:
                    if R > nr >= 0 <= nc < C and grid[nr][nc]:
                        idx = nr * C + nc
                        root = find(idx)
                        if root not in used_roots:
                            current_max += size[root]
                        used_roots.add(root)
                max_size = max(max_size, current_max)
        return max_size