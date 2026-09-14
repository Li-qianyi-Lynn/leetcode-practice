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
17    int maxSum = Integer.MIN_VALUE; //(choose left + right + node.val)
18    public int maxPathSum(TreeNode root) {
19        dfs(root);
20        return maxSum;
21        
22    }
23
24    private int dfs(TreeNode node) {
25        if (node == null) {
26            return 0;
27
28        }
29
30        int leftPath = Math.max(dfs(node.left),0);
31        int rightPath = Math.max(dfs(node.right),0);
32
33        maxSum = Math.max(maxSum, leftPath + rightPath + node.val);
34        return Math.max(leftPath,rightPath) + node.val;
35
36    }
37}
38
39/**
40        node(choose left/right)
41left
42            right
43
44
45 */