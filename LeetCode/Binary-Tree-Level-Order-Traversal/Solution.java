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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        /**
19        bfs 
20        use deque to store the node
21        use size as a snapshot : how many nodes in one level
22
23        */
24        
25        // sanity check
26        List<List<Integer>> res = new ArrayList<>();
27        if (root == null) {
28            return res;
29        }
30
31        Deque<TreeNode> deque = new ArrayDeque<>();
32        deque.offerLast(root);
33
34        while (!deque.isEmpty()) {
35            int size = deque.size();
36            List<Integer> levelNode = new ArrayList<>();
37            for (int i = 1; i <= size; i++) {
38                TreeNode poll = deque.pollFirst();
39                levelNode.add(poll.val);
40                
41                if (poll.left != null) {
42                    deque.offerLast(poll.left);
43                }
44
45                if (poll.right != null) {
46                    deque.offerLast(poll.right);
47                }
48
49            }
50            res.add(levelNode);
51
52        }
53        return res;
54    }
55}