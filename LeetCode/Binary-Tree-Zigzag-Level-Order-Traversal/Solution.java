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
18        List<List<Integer>> res = new ArrayList<>();
19        if (root == null) {
20            return res;
21        }
22
23        Deque<TreeNode> dq = new ArrayDeque<>();
24        dq.offerLast(root);
25       // 0 +. 1 -
26
27        while (!dq.isEmpty()) {
28            int size = dq.size();
29            List<Integer> curLevel = new ArrayList<>();
30            for (int i = 0; i < size; i++) {
31
32                TreeNode poll = dq.pollFirst();
33                if (poll.left != null) {
34                    dq.offerLast(poll.left);
35                }
36
37                if (poll.right != null) {
38                    dq.offerLast(poll.right);
39                }
40                curLevel.add(poll.val);
41
42
43            }
44            if (res.size() % 2 != 0) {
45                Collections.reverse(curLevel);
46            }
47            res.add(curLevel);
48        }
49        return res;
50
51        
52    }
53}
54/**
55bfs
56!flag -> last/first
57
58[9,20]
59
60polllast
61[20,]
62
63 */