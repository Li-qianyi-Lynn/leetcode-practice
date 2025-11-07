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
        if (root == null) {
            return res;
        }
        bfs(root,res);
        return res;
        
    }
    private void bfs(TreeNode root, List<Integer> res) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 1; i <= size; i++) {
                TreeNode poll = deque.pollFirst();
                if (poll.left != null) {
                    deque.offerLast(poll.left);

                }
                if (poll.right != null) {
                    deque.offerLast(poll.right);

                }
                if (i == size) {
                    res.add(poll.val);

                }

            }

        }

    }
}