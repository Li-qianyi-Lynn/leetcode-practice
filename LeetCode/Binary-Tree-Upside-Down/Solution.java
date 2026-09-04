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
17    public TreeNode upsideDownBinaryTree(TreeNode root) {
18        if (root == null || root.left == null) {
19            return root;
20
21        }
22
23        TreeNode newNode = upsideDownBinaryTree(root.left);
24        TreeNode newRoot = root.left;
25        newRoot.left = root.right;
26        newRoot.right = root;
27
28        root.left = null;
29        root.right = null;
30        
31        return newNode;
32        /**
33        
34        y
35
36     z      x
37
38        z
39
40    x        y
41             
42         */
43        
44    }
45}