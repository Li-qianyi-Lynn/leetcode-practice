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
12        //base case
13        if(root == null) return null;
14        if (root == p || root == q) return root;
15
16        
17        TreeNode l = lowestCommonAncestor(root.left, p, q);
18        TreeNode r = lowestCommonAncestor(root.right, p, q);
19
20        if (l != null && r != null) return root;
21
22        if (l != null) return l;
23        return r;
24        
25    }
26}