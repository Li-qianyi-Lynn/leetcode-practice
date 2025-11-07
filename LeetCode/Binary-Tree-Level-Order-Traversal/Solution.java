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
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root, 0);
        return resList;   
    }

    private void bfs(TreeNode node, Integer deep) {
        if (node == null) {
            return;

        }

        deep++;
        if (resList.size() < deep) {
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);

        }
        resList.get(deep-1).add(node.val);
        bfs(node.left, deep);
        bfs(node.right, deep);

    }
}