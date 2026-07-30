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
17    public int maxDepth(TreeNode root) {
18        if (root == null) return 0;
19        int depth = 0;
20        Deque<TreeNode> deque = new LinkedList<>();
21        deque.offerLast(root);
22        while (!deque.isEmpty()) {
23            depth++;
24            int size = deque.size();
25            for (int i =1; i <= size; i++) {
26                TreeNode poll = deque.pollFirst();
27                if (poll.left != null) {
28                    deque.offerLast(poll.left);
29                }
30                if (poll.right != null) {
31                    deque.offerLast(poll.right);
32                }
33
34            }
35
36        }
37        return depth;
38   
39    }
40
41  
42}