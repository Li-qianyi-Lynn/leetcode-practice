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
20        count = 0;
21        res = 0;
22
23        inorder(root, k);
24        return res;
25    }
26
27    private void inorder(TreeNode root, int k) {
28        if (root == null) return;
29
30        inorder(root.left, k);
31        count++;
32        if (count == k) {
33            res = root.val;
34            return;
35
36        }
37        inorder(root.right, k);
38
39    }
40}
41
42// time complexity: O(h+k) h: height of the tree
43// space complexity: O(h) depth of the stack