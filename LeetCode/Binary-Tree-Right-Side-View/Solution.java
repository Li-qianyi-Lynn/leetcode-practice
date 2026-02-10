1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public List<Integer> rightSideView(TreeNode root) {
18    List<Integer> result = new ArrayList<>();
19    dfs(root, 0, result);
20    return result;
21}
22
23    private void dfs(TreeNode node, int depth, List<Integer> result) {
24        if (node == null) return;
25
26        // If depth matches result size, this is the first (rightmost) node at this level
27        if (depth == result.size()) {
28            result.add(node.val);
29        }
30
31        // Prioritize Right child to ensure it's processed first at each depth
32        dfs(node.right, depth + 1, result);
33        dfs(node.left, depth + 1, result);
34    }
35}