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
18    public int longestZigZag(TreeNode root) {
19        dfs(root.left,1,false);
20        dfs(root.right,1,true);
21        return res;    
22    }
23
24    private void dfs(TreeNode node, int curPath, boolean goLeft) {
25        // base case
26        if (node == null) {
27            return;
28        }
29
30        // update the res
31        res = Math.max(curPath, res); //0
32
33        // how to divide
34        // left child tree
35        if (goLeft) {
36            dfs(node.left, curPath+1, false);
37            dfs(node.right, 1, true);
38        } else { // go right
39            dfs(node.right, curPath+1, true); //4
40            dfs(node.left, 1, false);
41        }
42
43
44    }
45}
46
47/**
48input: tree node
49output: int longest ZigZag path 
50
51dfs
522 choice:
53curpath
54go left -> 
55-go right ---- curpath+1
56-go left --- curpath == 0
57go right -> go left ---- curpath+1
58
59
60 */