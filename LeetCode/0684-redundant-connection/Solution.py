class Solution:
    def findRedundantConnection(self, edges: list[list[int]]) -> list[int]:
        graph = defaultdict(list)
        for u,v in edges:
            graph[u].append(v)
            graph[v].append(u)


        n = len(edges)
        cycle_node=set()
        visited = set()
        parents = [0] * (n+1)
        found = False

        def dfs(node, par):
            nonlocal found
            visited.add(node)
            parents[node] = par

            for nei in graph[node]:
                if found:
                    return
                if nei == par:
                    continue
                if nei in visited:
                    cur = node
                    while cur != nei:
                        cycle_node.add(cur)
                        cur = parents[cur]
                    cycle_node.add(nei)
                    found = True
                dfs(nei, node)
        dfs(1,-1)

        for u,v in reversed(edges): 
            if u in cycle_node and v in cycle_node:
                return [u,v]
        



"""
step1 graph 


cycle_node=set()
visited = set()
found = False
node,parents -> dfs



"""       