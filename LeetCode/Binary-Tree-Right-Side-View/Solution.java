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
17    public List<Integer> rightSideView(TreeNode root) {
18        // edge case
19        List<Integer> res = new ArrayList<>();
20        if (root == null) return res;
21        Deque<TreeNode> deque = new LinkedList<>();
22        deque.offerLast(root);
23        while (!deque.isEmpty()) {
24            int size = deque.size();
25
26            for (int i = 1; i <= size; i++) {
27                TreeNode poll = deque.pollFirst();
28                if (poll.left != null) {
29                    deque.offerLast(poll.left);
30                }
31                if (poll.right != null) {
32                    deque.offerLast(poll.right);
33                }
34                if (i == size) {
35                    res.add(poll.val);
36                }
37            }
38        }
39        return res;     
40    }
41}