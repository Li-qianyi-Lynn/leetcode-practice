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
31            int currentVal = 101;
32            List<TreeNode> nextLevel = new ArrayList<>();
33
34            // Iterate through every node in the current level list
35            for (TreeNode node : currentLevel) {
36                // Add the node's value to the current level's result list
37                currentVal = node.val;
38
39                // If children exist, add them to the next level list
40                if (node.left != null) {
41                    nextLevel.add(node.left);
42                }
43                if (node.right != null) {
44                    nextLevel.add(node.right);
45                }
46            }
47
48            // Append the finished level to the final result
49            result.add(currentVal);
50            
51            // Move to the next level (the "Two-Lists" swap)
52            currentLevel = nextLevel;
53        }
54
55        return result;
56    }
57}
58