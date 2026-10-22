class Solution:
    def findRedundantConnection(self, edges: list[list[int]]) -> list[int]:
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        visited = set()
        path = []
        cycle_nodes = []

        # 2. DFS 找环
        def dfs(curr: int, parent: int) -> bool:
            nonlocal cycle_nodes
            visited.add(curr)
            path.append(curr)

            for neighbor in adj[curr]:
                if neighbor == parent:
                    continue

                if neighbor in visited:
                # 发现环：neighbor 是环的起点
                    idx = path.index(neighbor)
                    cycle_nodes = path[idx:]
                    return True

                if dfs(neighbor, curr):
                    return True

            path.pop()
            return False

        # 题目保证图连通且有环，从任意节点（如 edges[0][0]）开始 DFS 即可
        dfs(edges[0][0], -1)

        # 3. 将环上的点转换成边集合（规范化为无向边 (min, max)）
        cycle_edges = set()
        for i in range(len(cycle_nodes)):
            u = cycle_nodes[i]
            v = cycle_nodes[(i + 1) % len(cycle_nodes)]
            cycle_edges.add((min(u, v), max(u, v)))

        # 4. 逆向遍历原始 edges，找到在环中最后出现的那条边
        for u, v in reversed(edges):
            edge = (min(u, v), max(u, v))
            if edge in cycle_edges:
                return [u, v]

        return []

        