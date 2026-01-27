1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
12        // base case
13        if(root == null) return null;
14        if (root.val == p.val || root.val == q.val) return root;
15
16        TreeNode l = lowestCommonAncestor(root.left, p,q);
17        TreeNode r = lowestCommonAncestor(root.right, p,q);
18
19        if (l != null && r != null) {
20            return root;
21        }
22        if (l != null) {
23            return l;
24
25        }
26        if (r != null) {
27            return r;
28
29        }
30
31        return null;
32    }
33
34
35}