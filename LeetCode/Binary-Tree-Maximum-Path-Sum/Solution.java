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
17    int maxV = Integer.MIN_VALUE;
18
19
20    public int maxPathSum(TreeNode root) {
21        if (root == null) {
22            return 0;
23        }
24        maxGain(root);
25        
26        return maxV;
27        
28    }
29
30    private int maxGain(TreeNode node) {
31        if (node == null) {
32            return 0;
33        }
34        int leftGain = Math.max(maxGain(node.left),0);
35        int rightGain = Math.max(maxGain(node.right),0);
36
37        maxV = Math.max(maxV, (node.val + leftGain + rightGain));
38        return node.val + Math.max(leftGain,rightGain);
39
40    }
41}
42/**
43
44helper:
45update max, pass child max to parent node
46
47curmax = node.val + leftmax + rightmax
48compare with max
49
50
51
52
53 */