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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        bfs(root, res);
        return res;
        
    }

    private void bfs(TreeNode root, LinkedList<List<Integer>>res) {
        if (root == null) return;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) { // traversel level
            int size = deque.size();
            List<Integer> levelNode = new ArrayList<>();

            for (int i = 1; i <=size; i++) {
                TreeNode poll = deque.pollFirst();
                if (poll.left != null) {
                    deque.offerLast(poll.left);

                }

                if (poll.right != null) {
                    deque.offerLast(poll.right);
                }
                levelNode.add(poll.val);
            }
            res.offerFirst(levelNode);
        
        }

    }
}