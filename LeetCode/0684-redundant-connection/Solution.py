class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        for u,v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        visited = set()
        found = False
        n = len(edges)
        parents = [0] * (n+1)
        cycle_nodes = set()



        def dfs(node,par):
            nonlocal found
            visited.add(node)
            parents[node] = par

            for nei in graph[node]:
                if found:
                    return
                if nei == par:
                    continue
                if nei in visited: #node -> parent 回溯到nei
                    cur = node
                    while cur != nei:
                        cycle_nodes.add(cur)
                        cur = parents[cur]
                    cycle_nodes.add(nei)
                    found = True
                    return
                dfs(nei,node)

        
        dfs(1,-1)

        for u,v in reversed(edges):
            if u in cycle_nodes and v in cycle_nodes:
                return [u,v]

        

"""

1. 先把图全部建好
2. 找到环上所有节点
3. 倒序找答案
"""