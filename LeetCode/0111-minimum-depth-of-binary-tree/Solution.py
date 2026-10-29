# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: TreeNode | None) -> int:
        # bfs: if the node has no left and right child node, we can return the depth directly,

        #edge case number of nodes = 0 return 0
        # tc: O(n) sc: O(n)

        if not root:
            return 0
        
        q = deque()
        q.append(root)
        depth = 0
        while q:
            size = len(q) # 2
            depth += 1 # 2
            for i in range(size):
                cur = q.popleft() #[9,20]
                if not cur.left and not cur.right:
                    return depth
                
                if cur.left:
                    q.append(cur.left)

                if cur.right:
                    q.append(cur.right)
        

        return depth


            
            
        