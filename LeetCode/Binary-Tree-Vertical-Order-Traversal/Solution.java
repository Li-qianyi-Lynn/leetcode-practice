class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        def dfs(node: Optional[TreeNode]):
            if not node:
                return

            dfs(node.left)
            dfs(node.right)

        dfs(root)