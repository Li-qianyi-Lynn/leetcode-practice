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
17    public boolean isSymmetric(TreeNode root) {
18        Deque<TreeNode> dq = new LinkedList<>();
19        dq.offerLast(root);
20        dq.offerLast(root);
21        while (!dq.isEmpty()) {
22            TreeNode cur1 = dq.pollFirst();
23            TreeNode cur2 = dq.pollFirst();
24            if (cur1 == null && cur2 == null) {
25                continue;
26            }
27            if (cur1 == null || cur2 == null ) {
28                return false;
29            }
30            if (cur1.val != cur2.val) {
31                return false;
32            }
33            dq.offerLast(cur1.left);
34            dq.offerLast(cur2.right);
35            dq.offerLast(cur1.right);
36            dq.offerLast(cur2.left);
37        }
38        return true;
39        
40    }
41}