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
17
18    // inorder reversal
19    public boolean isValidBST(TreeNode root) {
20        List<Integer> res = new ArrayList<>();
21        inorder(root,res);
22        for (int i = 1; i < res.size(); i++) {
23            if (res.get(i) <= res.get(i-1)) {
24                return false;
25            }
26
27        }
28        return true;    
29    }
30
31   private void inorder(TreeNode root, List<Integer> res) {
32        if (root == null) return;
33
34        inorder(root.left, res);
35        res.add(root.val);
36        inorder(root.right,res);
37
38   }
39}