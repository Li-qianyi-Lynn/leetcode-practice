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
        #init clone: old node -> new node || -> new node(val)
        clone = {}

        # helper: old node -> new node
            # base case check map old node 
        def helper(node):
            if node in clone:
                return clone[node]
            
            if not node:
                return None
             
             #fill neibors ? 1,[2,4] -> Node (1,[])  node.neibors

            newNode = Node(node.val)
            clone[node] = newNode
            for nei in node.neighbors:
                newNode.neighbors.append(helper(nei))
            return newNode
        
        return helper(node)