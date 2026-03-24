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
17    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
18        if (root == null) {
19            return new ArrayList<>();
20        }
21
22        Deque<TreeNode> dq = new ArrayDeque<>();
23        List<List<Integer>> res = new ArrayList<>();
24        boolean leftToRight = true;
25
26        dq.offerLast(root);
27        while (!dq.isEmpty()) { // tree
28            int size = dq.size();
29            List<Integer> cur = new ArrayList<>();
30            for (int i = 0; i < size; i++) { // level
31                TreeNode poll = dq.pollFirst();
32                if (poll.left != null) {
33                    dq.offerLast(poll.left);
34                }
35                if (poll.right != null) {
36                    dq.offerLast(poll.right);
37                }
38
39                if (leftToRight) {
40                    cur.add(poll.val);
41                } else {
42                    cur.addFirst(poll.val);
43                }
44            }
45            res.add(cur);
46            leftToRight = !leftToRight;
47
48        }
49        return res;    
50    }
51}
52
53/**
54use bfs, traversal level by level
55boolean leftToRight = true offerLast, pollFirst; if no ,  offerFirst, pollLast
56
57
58 */