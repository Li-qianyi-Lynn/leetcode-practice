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
17    // use preorder traversal 
18    public TreeNode sortedArrayToBST(int[] nums) {
19        return preorder(nums, 0, nums.length-1);     
20    }
21
22    private TreeNode preorder(int[] nums, int l, int r) {
23        // base case
24        if (l > r) {
25            return null;
26
27        }
28
29        int mid = l + (r - l) / 2;
30        TreeNode root = new TreeNode(nums[mid]);
31
32        root.left = preorder(nums, l, mid-1);
33        root.right = preorder(nums, mid +1, r);
34
35        return root;
36
37    }
38}