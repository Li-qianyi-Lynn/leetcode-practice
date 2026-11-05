"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
            
        memo = {} 
        
        def dfs(curr):
           
            if curr in memo:
                return memo[curr]
            
            clone = Node(curr.val)
            memo[curr] = clone
            
            for nei in curr.neighbors:
                clone.neighbors.append(dfs(nei))
                
            return clone
            
        return dfs(node)
            

'''
map = oldnode -> newnode
@lru_cache
memo
dfs to check map

'''