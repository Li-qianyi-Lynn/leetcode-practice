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
16
17
18class Solution {
19    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
20        List<List<Integer>> res = new ArrayList<>();
21        if (root == null) return res;
22        bfs(root, res);
23        return res;   
24    }
25
26    private void bfs(TreeNode root, List<List<Integer>>res) {
27        if (root == null) return;
28        Deque<TreeNode> deque = new LinkedList<>();
29        boolean leftToRight = true;
30
31        deque.offerLast(root);
32        while(!deque.isEmpty()) {
33            int size = deque.size();
34
35            List<Integer> temp = new ArrayList<>();
36
37            for (int i = 0; i < size; i++) {
38                if (leftToRight) {
39                    TreeNode poll = deque.pollFirst();
40                    if (poll.left != null) {
41                        deque.offerLast(poll.left);
42                    }
43                    if (poll.right != null) {
44                        deque.offerLast(poll.right);
45                    }
46                    temp.add(poll.val);
47                    continue;
48                }
49                TreeNode poll = deque.pollLast();
50                if (poll.right != null) {
51                    deque.offerFirst(poll.right);
52                }
53                if (poll.left != null) {
54                    deque.offerFirst(poll.left);
55                }
56                temp.add(poll.val);
57            }
58            res.add(temp);
59            leftToRight = !leftToRight;
60        }
61    }
62}