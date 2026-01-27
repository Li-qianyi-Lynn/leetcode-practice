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
12        // Base case
13        if (root == null) {
14            return null;
15        }
16        
17        if (root == p || root == q) {
18            return root;
19        }
20        
21        TreeNode left = lowestCommonAncestor(root.left, p, q);
22        TreeNode right = lowestCommonAncestor(root.right, p, q);
23        
24        if (left != null && right != null) {
25            return root;
26        }
27        
28        if (left != null) {
29            return left;
30        }
31        
32        return right;
33    }
34}