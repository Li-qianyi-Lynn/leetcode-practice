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
17    private long maxValue = Long.MAX_VALUE;
18    private long minValue = Long.MIN_VALUE;
19    
20    public boolean isValidBST(TreeNode root) {
21        return dfs(root, maxValue, minValue);
22        
23    }
24
25    private boolean dfs(TreeNode node, long maxCurValue, long minCurValue) {
26        //base case 
27        if (node == null) {
28            return true;
29        }
30
31        if (node.val >= maxCurValue ) {
32            return false;
33
34        }
35
36        if (node.val <= minCurValue) {
37            return false;
38        }
39
40        return dfs(node.left, node.val, minCurValue) && dfs(node.right, maxCurValue, node.val);
41 
42        
43    }
44}
45
46/**
47
48input: treenode root
49output: boolean 
50
51bst:
52left node value < root.value < right node.value
53
54dfs
55global []
56
57max value
58min value
59
60
61 */