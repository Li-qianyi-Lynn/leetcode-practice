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
17    public TreeNode constructFromPrePost(int[] pre, int[] post) {
18        return build(pre, 0, pre.length - 1, post, 0, post.length - 1);
19    }
20
21    private TreeNode build(int[] pre, int preStart, int preEnd,
22                            int[] post, int postStart, int postEnd) {
23        if (preStart > preEnd) return null;
24
25        TreeNode root = new TreeNode(pre[preStart]);
26        if (preStart == preEnd) return root; // 只有一个节点，直接返回
27
28        // 左子树的根值
29        int leftRootVal = pre[preStart + 1];
30
31        // 在 post 数组里找 leftRootVal 的位置(注意要在 postStart..postEnd 范围内找)
32        int idx = postStart;
33        while (post[idx] != leftRootVal) idx++;
34
35        int leftSize = idx - postStart + 1; // 左子树节点数
36
37        root.left = build(pre, preStart + 1, preStart + leftSize,
38                           post, postStart, idx);
39        root.right = build(pre, preStart + leftSize + 1, preEnd,
40                            post, idx + 1, postEnd - 1);
41
42        return root;
43    }
44}
45/**
46
47root left right
48
49
50left right root
51
52 */