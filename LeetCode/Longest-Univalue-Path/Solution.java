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
17    private int maxPath = 0;
18    public int longestUnivaluePath(TreeNode root) {
19        if (root == null) {
20            return 0;
21
22        }
23        dfs(root);
24        return maxPath;
25
26        
27    }
28    // count 
29    private int dfs(TreeNode node) {
30        /**
31        1. left / right 
32        2. left + root + right 父亲
33        */
34
35        // base case
36        if (node == null) {
37            return 0;
38        }
39        // left.val !=  node.val
40        // left child
41
42        int leftPath = dfs(node.left);
43        int rightPath = dfs(node.right);
44
45        int tempL = 0;
46        int tempR = 0;
47
48        if (node.left != null) {
49            if (node.val == node.left.val) {
50                tempL = leftPath+1;
51
52            }
53        }
54
55        if (node.right != null) {
56            if (node.val == node.right.val) {
57                tempR = rightPath+1;
58            }
59        }
60
61        maxPath = Math.max(maxPath, tempR + tempL);
62        return Math.max(tempL, tempR);
63        
64
65    }
66}