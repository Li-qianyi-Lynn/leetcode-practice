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
 
 BFS(root, res) to update res
 - deque to store the treenode of each level FIFO
 - List<Integer> to store the cur level node 
 - int size of deque means how many nodes in this level

 step1: put the cur level node(if root is not null) to the deque;
 step2: iterate current level nodes, check if it has children nodes (if it has , add to the deque);
 step3: add current level nodes to the res;
 
  */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;

        }
        bfs(root, res);
        return res;
        
    }

    private void bfs(TreeNode root, List<List<Integer>>res) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode poll = deque.pollFirst();
                if (poll.left != null) {
                    deque.offerLast(poll.left);
                }
                if (poll.right != null) {
                    deque.offerLast(poll.right);
                }
                cur.add(poll.val);
            }
            res.add(cur);
        }
    }
}