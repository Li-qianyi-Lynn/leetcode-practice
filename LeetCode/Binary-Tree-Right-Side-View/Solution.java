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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root == null) {
            return res;

        }
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int levelNodes = deque.size();
            for (int i = 1;i <= levelNodes;i++) {
                TreeNode poll = deque.pollFirst();
                if (poll.left != null) {
                    deque.addLast(poll.left);

                }
                if (poll.right != null) {
                    deque.addLast(poll.right);

                }

                if (i == levelNodes) {
                    res.add(poll.val);

                }

            }   

        }
        return res;

        
    }
}