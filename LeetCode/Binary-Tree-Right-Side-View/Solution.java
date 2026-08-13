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
22
23        Deque<TreeNode> dq = new ArrayDeque<>(); //queue
24        dq.offerLast(root);
25
26        while (!dq.isEmpty()) {
27            int size = dq.size();
28            for (int i = 0; i < size; i++) {
29                TreeNode poll = dq.pollFirst();
30                if (i == size-1) {
31                    res.add(poll.val);
32                }
33                if (poll.left != null) {
34                    dq.offerLast(poll.left);
35                }
36                if (poll.right != null) {
37                    dq.offerLast(poll.right);
38                }
39            }
40           
41        }
42        return res;
43        
44    }
45}
46/**
47
48bfs : 
49[1]
50[2,3] if i == size -1,add it to the res
51[5,4]
52
53 */