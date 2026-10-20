class Solution:
    def validTree(self, n: int, edges: list[list[int]]) -> bool:
        if len(edges) != n-1:
            return False
        adj = defaultdict(list)
        for u,v in edges:
            adj[u].append(v)
            adj[v].append(u)
        
        q = deque([0])
        visited = {0}

        while q:
            cur = q.popleft()
            for nei in adj[cur]:
                if nei not in visited:
                    visited.add(nei)
                    q.append(nei)
        
        return len(visited) == n