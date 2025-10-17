/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();

        if (root == null) {
            return depth;
        }

        deque.addLast(root);
        while (!deque.isEmpty()) {
            int levelNodes = deque.size();
            depth++;
            for (int i = 1;i <= levelNodes;i++) {
                TreeNode poll = deque.pollFirst();
                if (poll.left == null && poll.right == null) {
                    return depth;

                }

                if (poll.left != null) {
                    deque.addLast(poll.left);
                }
                if (poll.right != null) {
                    deque.addLast(poll.right);
                }
            }
    
        }
        return depth; 
    }
}