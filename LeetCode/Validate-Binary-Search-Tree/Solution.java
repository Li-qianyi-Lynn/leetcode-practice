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
17    long prev = Long.MIN_VALUE; // 用 long 防止节点值是 Integer.MIN_VALUE
18
19    public boolean isValidBST(TreeNode root) {
20        if (root == null) return true;
21
22        // 访问左子树
23        if (!isValidBST(root.left)) return false;
24
25        // 访问当前节点：必须大于前一个节点
26        if (root.val <= prev) return false;
27        prev = root.val;
28
29        // 访问右子树
30        return isValidBST(root.right);
31    }
32}
33/**
34inorder traversal
35
36
37 */