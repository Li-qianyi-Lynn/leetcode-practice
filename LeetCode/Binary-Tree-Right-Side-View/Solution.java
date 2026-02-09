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
19        Deque<TreeNode> deque = new LinkedList<>();
20
21        if (root == null) {
22            return res;
23
24        }
25        deque.addLast(root);
26
27        while (!deque.isEmpty()) {
28            int levelNodes = deque.size();
29            for (int i = 1;i <= levelNodes;i++) {
30                TreeNode poll = deque.pollFirst();
31                if (poll.left != null) {
32                    deque.addLast(poll.left);
33
34                }
35                if (poll.right != null) {
36                    deque.addLast(poll.right);
37
38                }
39
40                if (i == levelNodes) {
41                    res.add(poll.val);
42
43                }
44
45            }   
46
47        }
48        return res;
49
50        
51    }
52}