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
17    private int idx;
18    private int res = -1;
19    public int kthSmallest(TreeNode root, int k) {
20        idx = 0;
21        dfs(root, k);
22        return res;
23        
24        
25    }
26
27    private void dfs(TreeNode node, int k) {
28        //base case
29        if (node == null) {
30            return;
31        }
32        
33        dfs(node.left, k);
34        idx++;
35        if (idx == k) {
36            res = node.val;
37            return;
38
39        }
40        dfs(node.right, k);
41
42    }
43}
44/**
45priortyQueue: minHeap dfs -> O(n)
46
47bst + dfs (left + root + right) inorder
48
49
50
51
52
53
54 */