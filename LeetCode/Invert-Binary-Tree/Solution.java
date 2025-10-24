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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {return root;}
        Deque<TreeNode> deque = new LinkedList<>();

        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 1; i <=size; i++) {
                TreeNode cur = deque.pollFirst();
                swap(cur);
                if (cur.left != null) {deque.offerLast(cur.left);}
                if (cur.right != null) {deque.offerLast(cur.right);}
            }

        }

        return root;

        
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}