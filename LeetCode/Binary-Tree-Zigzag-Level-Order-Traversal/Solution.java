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
19        if (root == null) return res;
20        bfs(root, res);
21        return res;   
22    }
23
24    private void bfs(TreeNode root, List<List<Integer>>res) {
25        if (root == null) return;
26        Deque<TreeNode> deque = new LinkedList<>();
27        boolean leftToRight = true;
28
29        deque.offerLast(root);
30        while(!deque.isEmpty()) {
31            int size = deque.size();
32            List<Integer> levelNode= new LinkedList<>();
33
34            for (int i = 1; i <= size; i++) {
35                TreeNode poll = deque.pollFirst();
36                levelNode.add(poll.val);
37                if (poll.left != null) {
38                        deque.offerLast(poll.left);
39                    } 
40                    if (poll.right != null) {
41                        deque.offerLast(poll.right);
42                    }
43                
44            }
45            if (!leftToRight) {
46                Collections.reverse(levelNode);
47            }
48            res.add(levelNode);
49            leftToRight = !leftToRight;
50        }
51        
52    
53    }
54}