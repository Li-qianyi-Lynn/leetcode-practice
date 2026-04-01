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
17    Map<Integer, Integer> map = new HashMap<>();// int -> index for inorder
18    int index; // for postorder
19    public TreeNode buildTree(int[] inorder, int[] postorder) {
20        if (inorder.length == 1) {
21            return new TreeNode(inorder[0]);
22        }
23        for (int i = 0; i < inorder.length; i++) {
24            map.put(inorder[i],i);
25        }
26        index = postorder.length-1;
27
28        return dfs(postorder, 0, index);
29    }
30    private TreeNode dfs(int[] postorder, int l, int r) {
31        // base case
32        if (l > r) {
33            return null;
34        }
35
36        int rootVal = postorder[index--];
37        int rootIdx = map.get(rootVal);
38        TreeNode root = new TreeNode(rootVal);
39        root.right = dfs(postorder, rootIdx+1, r);
40        root.left = dfs(postorder, l,rootIdx-1);
41        return root;
42
43
44
45    }
46}
47/**
48inorder: left root right 定位左子树和右子树-
49postorder: left right root 去找根节点
50
51
52
53
54
55 */