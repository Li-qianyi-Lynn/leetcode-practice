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
17    private int count;
18    private int res;
19    public int kthSmallest(TreeNode root, int k) {
20        // edge case
21        if (root == null) {
22            return 0;
23        }
24
25        count = 0;
26        res = -1; // node.val
27        inorder(root,k);
28        return res;
29
30
31       
32        
33    }
34
35    private void inorder(TreeNode node, int k) {
36        if (node == null || res != -1 ) {
37            return;
38        }
39
40        inorder(node.left,k);
41        count++;
42        if (count == k) {
43            res = node.val;
44            return;
45
46        }
47
48        inorder(node.right, k);
49
50    }
51
52
53
54    
55}
56
57/**
58bst
59left < root < right
60
61dfs -> smallest -> biggest 
62
63
64
65 */