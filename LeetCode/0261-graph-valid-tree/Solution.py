class Solution:
    def validTree(self, n: int, edges: list[list[int]]) -> bool:
        #undirected edge 
        """
        input: n ->num of nodes, edges List
        output: boolean

        true: 1)0 -> all other nodes 2)no cycle
        1) union find
        2) dfs: visited set
        
        """
        edg = len(edges)
        if edg == 0 and n != 1:
            return False
        
        if edg != n-1:
            return False
        # 0 1 2 3 4
        # [0,1,2,3,4]
        parents = [0] * n 
        for i in range(n):
            parents[i] = i
#[[0],[1],[2],[3],[4]]
        def find(x):
            if parents[x] != x:
                parents[x] = find(parents[x])
            
            return parents[x]
        
        def union(x, y):
            root_x = find(x)
            root_y = find(y)

            if root_x != root_y:
                parents[root_x] = root_y
                return True
            
            return False

        
        for u,v in edges:
            cur_res = union(u,v)
            if not cur_res:
                return False

        return True

        #tc: O(nlogn) sc:O(n)

# 2-3

# 0-1
# | /
# 4

        



        