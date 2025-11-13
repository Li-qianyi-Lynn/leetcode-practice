from collections import deque

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return []
        visited = set()
        root_node = Node(node.val, [])
        q = deque([(root_node, node)])
        
        while q:
            clone, curr = q.popleft()
            if curr.val in visited:
                continue
            visited.add(curr.val)
            
            for neighbor in curr.neighbors:
                new_neighbor = Node(neighbor.val, [])
                clone.neighbors.append(new_neighbor)
                q.append((new_neighbor, neighbor))
        
        return root_node