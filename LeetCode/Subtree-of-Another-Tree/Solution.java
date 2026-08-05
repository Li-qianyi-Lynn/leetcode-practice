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
17    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
18        if (root == null) {
19            return subRoot == null;
20
21        }
22
23        if (dfs(root,subRoot)) {
24            return true;
25
26        }
27
28        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
29        
30    }
31
32    private boolean dfs(TreeNode root, TreeNode subRoot) {
33        //base case
34        if (root == null && subRoot == null) {
35            return true;
36
37        }
38        if (root == null || subRoot == null) {
39            return false;
40
41        }
42
43        if (root.val != subRoot.val) {
44            return false;
45
46        }
47
48        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
49
50
51
52
53    }
54}