"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        #q ()deque -> neibors
        #visited old node ->new node
        if not node:
            return None

        q = deque()
        visited = {node: Node(node.val)}

        
        
        q.append(node)
        while q:
            cur_node = q.popleft()
            
            for nei in cur_node.neighbors:
                if nei not in visited:
                    q.append(nei)
                    new_node = Node(nei.val)
                    visited[nei] = new_node
            
                visited[cur_node].neighbors.append(visited[nei])
        
        return visited[node]
                    