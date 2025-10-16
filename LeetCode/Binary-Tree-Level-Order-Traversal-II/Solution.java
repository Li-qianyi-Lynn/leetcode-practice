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
    public List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        bfs(root, 0);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = list.size()-1; i >= 0; i--) {
            res.add(list.get(i));

        }
        return res;


        
    }

    private void bfs(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        if (list.size() < deep) {
            List<Integer> item = new ArrayList<Integer>();
            list.add(item);
        }
        list.get(deep - 1).add(node.val);

        bfs(node.left, deep);
        bfs(node.right, deep);
    }
}