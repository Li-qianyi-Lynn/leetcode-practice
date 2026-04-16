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
17    int res = 0;
18    public int goodNodes(TreeNode root) {
19        dfs(root,root.val);
20        return res;
21        
22    }
23
24    private void dfs(TreeNode node, int curMax) {
25        // base case
26        if (node == null) {
27            return;
28        }
29
30        // how to update the res
31        if (node.val >= curMax) {
32            res++; //4
33        }
34        curMax = Math.max(curMax, node.val); // 5
35
36        // how to divide
37        dfs(node.left, curMax);
38        dfs(node.right, curMax);
39    }
40}
41
42/**
43input: TreeNode node
44output: int -  the number of good nodes 
45
46int res 
47
48good:
49if node.val >= curMax -> node is good -> res+1
50
51
52 */