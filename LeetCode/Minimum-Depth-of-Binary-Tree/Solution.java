class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        queue = deque([(root, 1)])
        if not root: return 0

        while queue:
            node, level = queue.popleft()

            if not node.left and not node.right:
                return level

            if node.left:
                queue.append((node.left, level+1))
            if node.right:
                queue.append((node.right, level+1))