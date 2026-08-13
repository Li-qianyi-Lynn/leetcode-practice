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
17    public int kthSmallest(TreeNode root, int k) {
18        List<Integer> res = new ArrayList<>();
19        inorder(root, res);
20        return res.get(k-1);
21        
22    }
23    private void inorder(TreeNode root, List<Integer>res) {
24        if (root == null) return;
25
26        inorder(root.left, res);
27        res.add(root.val);
28        inorder(root.right, res);
29
30    }
31}