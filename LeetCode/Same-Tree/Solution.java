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
17    public boolean isSameTree(TreeNode p, TreeNode q) {
18        //base case
19        if (p == null && q == null) {
20            return true;
21        }
22        if (p == null || q == null) {
23            return false;
24        }
25        
26        if (p.val != q.val) {
27            return false;
28        }
29       
30        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right); 
31
32        
33    }
34}
35/**
36
37
38input: two treeNode p,q
39output: boolean 
40
41same:
421. nodes same
432. node.val same
44
45dfs
46
47
48
49
50 */