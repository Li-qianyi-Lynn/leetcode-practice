# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: TreeNode | None) -> int:
        if not root:
            return 0
        
        if not root.left and not root.right:
            return 1
        
        lef = self.minDepth(root.right)   
        
        rig = self.minDepth(root.left)
        
        if lef and rig:
            return 1 + min(lef, rig)
        elif lef:
            return 1 + lef
        elif rig:
            return 1 + rig

        