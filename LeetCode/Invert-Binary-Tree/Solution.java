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
17    public TreeNode invertTree(TreeNode root) {
18        if (root == null) {
19            return root;
20        }
21
22        Deque<TreeNode> dq = new ArrayDeque<>();
23        dq.offerLast(root);
24        while (!dq.isEmpty()) {
25            int size = dq.size();
26            for (int i = 0; i < size; i++) {
27                TreeNode cur = dq.pollFirst();
28                if (cur.left != null) {
29                    dq.offerLast(cur.left);
30                }
31
32                if (cur.right != null) {
33                    dq.offerLast(cur.right);
34                }
35                swap(cur);
36
37
38            }
39
40
41        }
42        return root;
43        
44    }
45    private TreeNode swap(TreeNode node) {
46        TreeNode temp = node.left;
47        node.left = node.right;
48        node.right = temp;
49        return node;
50
51    }
52}