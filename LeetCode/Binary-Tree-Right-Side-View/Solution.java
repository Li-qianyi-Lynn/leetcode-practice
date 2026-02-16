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
18        List<Integer> result = new ArrayList<>();
19        
20        // if the tree is empty, return an empty list
21        if (root == null) {
22            return result;
23        }
24
25        // Initialize the current level with the root node
26        List<TreeNode> currentLevel = new ArrayList<>();
27        currentLevel.add(root);
28
29        // Continue as long as there are nodes to process in the current level
30        while (!currentLevel.isEmpty()) {
31            // The right-side view is just the last element of each level
32            TreeNode lastNode = currentLevel.get(currentLevel.size() - 1);
33            result.add(lastNode.val);
34
35            List<TreeNode> nextLevel = new ArrayList<>();
36            for (TreeNode node : currentLevel) {
37                if (node.left != null) nextLevel.add(node.left);
38                if (node.right != null) nextLevel.add(node.right);
39            }
40            currentLevel = nextLevel;
41        }
42
43
44        return result;
45    }
46}
47