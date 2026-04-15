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
17    public TreeNode searchBST(TreeNode root, int val) {
18        // base case
19        if (root == null) {
20            return null;
21
22        }
23
24        if (root.val == val) {
25            return root;
26
27        }
28
29        TreeNode l = searchBST(root.left, val);
30        TreeNode r = searchBST(root.right, val);
31
32        if (l != null) {
33            return l;
34
35        } else if (r != null) {
36            return r;
37
38        } else {
39            return null;
40        }
41        
42        
43    }
44}