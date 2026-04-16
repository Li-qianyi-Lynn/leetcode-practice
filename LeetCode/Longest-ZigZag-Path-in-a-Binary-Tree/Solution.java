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
19        dfs(root.right,1,true);
20        dfs(root.left,1,false);
21        
22        return res;    
23    }
24
25    private void dfs(TreeNode node, int curPath, boolean goLeft) {
26        // base case
27        if (node == null) {
28            return;
29        }
30
31        // update the res
32        res = Math.max(curPath, res); //0
33
34        // how to divide
35        // left child tree
36        if (goLeft) {
37            dfs(node.left, curPath+1, false);
38            dfs(node.right, 1, true);
39        } else { // go right
40            dfs(node.right, curPath+1, true); //4
41            dfs(node.left, 1, false);
42        }
43
44
45    }
46}
47
48/**
49input: tree node
50output: int longest ZigZag path 
51
52dfs
532 choice:
54curpath
55go left -> 
56-go right ---- curpath+1
57-go left --- curpath == 0
58go right -> go left ---- curpath+1
59
60
61 */