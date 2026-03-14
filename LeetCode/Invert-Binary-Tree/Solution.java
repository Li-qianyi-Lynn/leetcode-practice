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
17    public TreeNode invertTree(TreeNode root) {
18        // base case
19
20        if (root == null) {
21            return root;
22
23        }
24        if (root.left == null && root.right == null) {
25            return root;
26
27        }
28        TreeNode ri = invertTree(root.right);
29        TreeNode le = invertTree(root.left);
30        root.right = le;
31        root.left = ri;
32        return root;
33         
34        
35    }
36
37}