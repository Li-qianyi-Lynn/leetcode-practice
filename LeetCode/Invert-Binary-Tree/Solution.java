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
18        if (root == null) {return root;}
19        Deque<TreeNode> deque = new LinkedList<>();
20
21        deque.offerLast(root);
22        while (!deque.isEmpty()) {
23            int size = deque.size();
24            for (int i = 1; i <=size; i++) {
25                TreeNode cur = deque.pollFirst();
26                
27                if (cur.left != null) {deque.offerLast(cur.left);}
28                if (cur.right != null) {deque.offerLast(cur.right);}
29                swap(cur);
30            }
31
32        }
33
34        return root;
35
36        
37    }
38
39    private void swap(TreeNode root) {
40        TreeNode temp = root.left;
41        root.left = root.right;
42        root.right = temp;
43    }
44}