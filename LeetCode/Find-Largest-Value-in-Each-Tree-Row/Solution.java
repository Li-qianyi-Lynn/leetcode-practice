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

        if (root == null) {
            return res;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) { // iterate all levels
            int levelNodes = deque.size();
            int max = Integer.MIN_VALUE;
            
            for (int i = 1;i <= levelNodes;i++) { // iterate each level nodes
                TreeNode poll = deque.pollFirst();
                max = Math.max(max, poll.val);
                if (poll.left != null) {
                    deque.addLast(poll.left);
                }
                if (poll.right != null) {
                    deque.addLast(poll.right);
                }
            }
            res.add(max);

        }
        return res;
        
    }
}