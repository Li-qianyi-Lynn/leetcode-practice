# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: TreeNode | None) -> int:
        res = 0
        # parent -> children top-down via depth parameter
        def dfs(node, depth):
            nonlocal res

            if not node:
                return 
            res = max(res,depth)
            dfs(node.left, depth+1)
            dfs(node.right, depth+1)
            
        dfs(root,1)
        return res