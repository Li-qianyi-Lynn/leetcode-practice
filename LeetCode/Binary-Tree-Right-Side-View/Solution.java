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
19        if (root == null) return new ArrayList<>();
20
21        List<Integer> result = new ArrayList<>();
22        Queue<TreeNode> queue = new ArrayDeque<>();
23        queue.offer(root);// first level
24
25        while (!queue.isEmpty()) {
26            int levelSize = queue.size(); // Number of nodes at the current level
27            for (int i = 0; i < levelSize; i++) {
28                TreeNode currentNode = queue.poll();
29                
30                // If it's the last element of the current level, add to result
31                if (i == levelSize - 1) {
32                    result.add(currentNode.val);
33                }
34                
35                if (currentNode.left != null) queue.offer(currentNode.left);
36                if (currentNode.right != null) queue.offer(currentNode.right);
37            }
38        }
39        return result;
40    }
41}