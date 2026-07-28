1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10
11class Solution {
12    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
13
14        // Base Case
15        if ( root == null || p == null || q == null ) {
16            return null;
17        }
18        if (p.val < root.val && q.val < root.val) {
19            return lowestCommonAncestor(root.left, p, q);
20        } else if ( q.val > root.val && p.val > root.val) {
21            return lowestCommonAncestor(root.right, p, q);
22        } else {
23
24            return root;  
25        }
26    }
27}