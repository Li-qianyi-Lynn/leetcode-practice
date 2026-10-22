class Solution:
    def findRedundantConnection(self, edges: list[list[int]]) -> list[int]:
        n = len(edges)
        parents = list(range(n+1))

        def find(x):
            if parents[x] != x:
                parents[x] = find(parents[x])
            return parents[x]
        
        def union(x,y):
            root_x = find(x)
            root_y = find(y)
            if root_x == root_y:
                return False
            else:
                parents[root_x] = root_y
                return True
        
        for u, v in edges:
            if not union(u, v):
                return [u, v]

        return []
        