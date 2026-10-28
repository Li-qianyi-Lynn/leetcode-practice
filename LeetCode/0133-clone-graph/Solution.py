"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []  
        Each list describes the set of neighbors of a node in the graph.
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        # visited : old node -> new node n
        # update neibor: iterate oldnode's neibor nodes dfs

        #tc: v+e sc:v
        # edge case: if 0: return new node
        if not node:
            return None
        visited = {}
        def dfs(node):
            #base case
            if not node:
                return None
            
            if node in visited:
                return visited[node]
            
            new_node = Node(node.val)
            visited[node] = new_node
            #update neibor: iterate oldnode's neibor nodes dfs
            for nei in node.neighbors:
                new_node.neighbors.append(dfs(nei))

            return new_node
            
        return dfs(node)
 


        