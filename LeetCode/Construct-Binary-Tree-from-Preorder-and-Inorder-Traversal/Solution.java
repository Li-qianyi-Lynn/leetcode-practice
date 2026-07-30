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
17    private HashMap<Integer, Integer> map;// inorder
18    private int idx; // preorder
19    public TreeNode buildTree(int[] preorder, int[] inorder) {
20        map = new HashMap<>();
21        idx = 0;
22
23        for (int i = 0; i < inorder.length; i++) {
24            map.put(inorder[i], i);
25        }
26
27        return dfs(preorder,0, preorder.length);
28
29        
30    }
31
32    private TreeNode dfs(int[] preorder, int l, int r) {
33        //base case
34        if (l > r || idx >= preorder.length) {
35            return null;
36
37        }
38
39        
40        TreeNode cur = new TreeNode(preorder[idx]); // root
41        // get root idx
42
43        int mid = map.get(cur.val);
44        idx++;
45        cur.left = dfs(preorder,l, mid-1);
46        cur.right = dfs(preorder,mid+1, r);
47
48        return cur;
49
50
51
52    }
53}
54
55/**
56
57map: inorder  value : index
58idx: follow root value  -> preorder
59[9,3,15,20,7]
60
61 */