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
17    public boolean isSymmetric(TreeNode root) {
18        return compare(root.left, root.right);
19        
20    }
21
22    private boolean compare(TreeNode left, TreeNode right) {
23        if (left == null && right != null) { return false;} 
24        if (right == null && left != null) { return false;}
25        if (left == null && right == null ) { return true;}
26        if (left.val != right.val) { return false;}
27
28        boolean outside = compare(left.left, right.right);
29        boolean inside = compare(left.right, right.left);
30
31        return outside && inside;
32    }
33}