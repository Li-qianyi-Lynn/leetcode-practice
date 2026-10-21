class Solution:
    def validTree(self, n: int, edges: list[list[int]]) -> bool:
        if len(edges) != n-1:
            return False
        parents = list(range(n))

        def find(x:int): # int -> int
            if parents[x] != x:
                parents[x] = find(parents[x])

            return parents[x]
        def union(x:int, y:int) ->bool:
            root_x,root_y = find(x),find(y)
            if root_x == root_y:
                return False
            parents[root_x] = root_y
            return True
        
        for u,v in edges:
            if not union(u,v):
                return False
        
        return True