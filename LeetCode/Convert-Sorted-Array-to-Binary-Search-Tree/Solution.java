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
17    public TreeNode sortedArrayToBST(int[] nums) {
18        return rec(0, nums.length-1, nums);
19
20        
21    }
22
23    private TreeNode rec(int l, int r, int[] nums) {
24        // base case
25        if (l > r) {
26            return null;
27
28        }
29
30        int mid = l + (r-l) / 2;
31        TreeNode root = new TreeNode(nums[mid]);
32        root.left = rec(l,mid-1, nums);
33        root.right = rec(mid+1, r, nums);
34        return root;
35
36    }
37}
38/**
39right.val < root < left.val
40
41find the mid point(root)
42left side value: small than root.val  mid -1;
43right side value: bigger than root.val  mid+1
44
45recursion: same patterns
461. base case : l > r we can stop
472. mid = l + (r-l) / 2 
483. preorder traversal
49root-mid
50left  change the r index
51right change the l index
52
53return root
54
55
56 */