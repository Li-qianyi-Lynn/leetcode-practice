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
17    Map<Integer, Integer> map = new HashMap<>(); // inorder val-> indices
18    int c;
19    public TreeNode buildTree(int[] inorder, int[] postorder) {
20        if (inorder.length == 1) {
21            return new TreeNode(inorder[0]);
22
23        }
24        c = postorder.length-1;
25        for (int i = 0; i < inorder.length; i++) {
26            map.put(inorder[i],i);
27        }
28        return dfs(postorder, 0,c);
29        
30    }
31
32    private TreeNode dfs(int[] postorder, int l, int r) {
33        // base case
34        if (l > r || c < 0) {
35            return null;
36
37        }
38
39        // get the root
40        int val = postorder[c];
41        int mid = map.get(val);
42        c--;
43        TreeNode root = new TreeNode(val);
44        root.right = dfs(postorder, mid+1,r);
45        root.left = dfs(postorder, l, mid-1);
46        
47        return root;
48
49
50    }
51}
52/**
53inorder: left root right
54postorder: left right root
55
56 */