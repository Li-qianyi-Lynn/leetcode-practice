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
18        List<Integer> res = new ArrayList<>();
19        if (root == null) {
20            return res;
21        }
22        bfs(root,res);
23        return res;
24        
25    }
26    private void bfs(TreeNode root, List<Integer> res) {
27        Deque<TreeNode> deque = new LinkedList<>();
28        deque.offerLast(root);
29        while (!deque.isEmpty()) {
30            int size = deque.size();
31            for (int i = 1; i <= size; i++) {
32                TreeNode poll = deque.pollFirst();
33                if (poll.left != null) {
34                    deque.offerLast(poll.left);
35
36                }
37                if (poll.right != null) {
38                    deque.offerLast(poll.right);
39
40                }
41                if (i == size) {
42                    res.add(poll.val);
43
44                }
45
46            }
47
48        }
49
50    }
51}