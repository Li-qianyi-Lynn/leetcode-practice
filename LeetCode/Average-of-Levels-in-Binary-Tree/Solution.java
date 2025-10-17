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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root==null) {
            return res;
        }

        deque.addLast(root);

        while (!deque.isEmpty()) {
            int levelNodes = deque.size();
            double sum = 0.0;

            for (int i = 1;i <= levelNodes;i++) {
                TreeNode poll = deque.pollFirst();

                sum += poll.val;
                
                if (poll.left != null) {
                    deque.addLast(poll.left);
                }
                if (poll.right != null) {
                    deque.addLast(poll.right);
                }
            }
            res.add(sum / levelNodes);
        }
        return res;
    }
}