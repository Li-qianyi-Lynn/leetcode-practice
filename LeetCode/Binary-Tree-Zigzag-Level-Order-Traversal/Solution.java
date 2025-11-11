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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        bfs(root, res);
        return res;   
    }

    private void bfs(TreeNode root, List<List<Integer>>res) {
        if (root == null) return;
        Deque<TreeNode> deque = new LinkedList<>();
        boolean leftToRight = true;

        deque.offerLast(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelNode= new LinkedList<>();

            for (int i = 1; i <= size; i++) {
                TreeNode poll = deque.pollFirst();
                levelNode.add(poll.val);
                if (poll.left != null) {
                        deque.offerLast(poll.left);
                    } 
                    if (poll.right != null) {
                        deque.offerLast(poll.right);
                    }
                
            }
            if (!leftToRight) {
                Collections.reverse(levelNode);
            }
            res.add(levelNode);
            leftToRight = !leftToRight;
        }
        
    
    }
}