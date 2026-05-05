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
17    public List<Integer> inorderTraversal(TreeNode root) {
18        List<Integer> res = new ArrayList<Integer>();
19        inOrder(res, root);
20        return res;
21    }
22
23    private void inOrder(List<Integer> res, TreeNode root) {
24        if (root == null) {
25            return;
26
27        }
28
29        inOrder(res, root.left);
30        res.add(root.val);
31        inOrder(res, root.right);
32
33    }
34}