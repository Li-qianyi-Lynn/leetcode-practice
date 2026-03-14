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
18        // base case
19        if (root== null) {
20            return true;
21        }
22        return helper(root.left, root.right);
23    }
24    private boolean helper(TreeNode nodel, TreeNode noder) {
25        // base case
26        if (nodel == null && noder == null) {
27            return true;
28        }
29        if (nodel == null || noder == null) {
30            return false;
31        }
32        if (nodel.val != noder.val) {
33            return false;
34        }
35
36        return helper(nodel.left,noder.right) && helper(nodel.right,noder.left);
37
38    }
39}