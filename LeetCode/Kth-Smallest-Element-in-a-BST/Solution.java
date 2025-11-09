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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        inorder(root, minheap);
        for (int i = 1; i < k; i++) {
            minheap.poll();

        }
        return minheap.poll();
        
    }
    private void inorder(TreeNode root, PriorityQueue<Integer> minheap) {
        if (root == null) return;

        inorder(root.left, minheap);
        minheap.offer(root.val);
        inorder(root.right, minheap);

    }
}