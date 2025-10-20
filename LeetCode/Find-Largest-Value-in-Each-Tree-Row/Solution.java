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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root == null)  return res;

        deque.offerLast(root);

        while (!deque.isEmpty()) {
            int levelNodes = deque.size(); // get the nodes amount in each level
            int max = Integer.MIN_VALUE;

            for (int i = 1; i <= levelNodes; i++) {
                TreeNode poll = deque.pollFirst();
                if (poll.left != null) deque.offerLast(poll.left);
                if (poll.right != null) deque.offerLast(poll.right);

                max = Math.max(max, poll.val);

            }
            res.add(max);

        }
        return res;
        
    }
}