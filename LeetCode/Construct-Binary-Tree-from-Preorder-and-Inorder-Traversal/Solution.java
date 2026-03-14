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
17    HashMap<Integer,Integer> map = new HashMap<>(); // val -> indices
18    int c = 0; // preorder pointer
19    
20
21    public TreeNode buildTree(int[] preorder, int[] inorder) {
22        if (preorder.length == 1) {
23            return new TreeNode(preorder[0]);
24
25        }
26        for (int i = 0; i < inorder.length; i++) {
27            map.put(inorder[i],i);
28        }
29        return dfs(preorder,0,preorder.length-1);
30        
31    }
32
33    private TreeNode dfs(int[] preorder, int l, int r) {
34        // base case
35        if (l > r) {
36            return null;
37        }
38
39        // get the root
40        int cur = preorder[c];
41        c++;
42        TreeNode root = new TreeNode(cur);
43        int mid = map.get(cur);
44        root.left = dfs(preorder,l,mid-1);
45        root.right = dfs(preorder,mid+1,r);
46        return root;
47    }
48}
49
50/**
51preorder:
52mid, left,right
53
54inorder:
55left, mid, right
56
57get the node, check the indx in inorder, 
58index.right: right side,
59index.left : left side
60
61 */