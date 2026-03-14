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
18        return dfs(root.left, root.right); //todo
19
20        
21    }
22
23    private boolean dfs(TreeNode lnode, TreeNode rnode) {
24        // base case
25        if (lnode == null && rnode == null) {
26            return true;
27            
28        }
29        if (lnode == null || rnode == null) {
30            return false;   
31        }
32        if (lnode.val != rnode.val) {
33            return false;  
34        }
35        
36        //how to divide a big problem into small problems
37        //outside
38        boolean outside = dfs(lnode.left, rnode.right);
39        boolean inside = dfs(lnode.right, rnode.left);
40        
41        return outside && inside;
42        
43        
44    }
45}