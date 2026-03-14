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
17    private Map<Integer, Integer> map = new HashMap<>();
18    private int index;// for postorder root locate
19    public TreeNode buildTree(int[] inorder, int[] postorder) {
20        //one case 
21        if (inorder.length == 1) {
22            return new TreeNode(inorder[0]);  
23        }
24        
25        // init the map
26        index = postorder.length-1;
27        for (int i = 0; i < inorder.length; i++) {
28            map.put(inorder[i], i);    
29        }
30        return dfs(postorder,0,inorder.length-1); // ?
31       
32    }
33    private TreeNode dfs(int[] postorder, int l, int r) {
34        // base case
35        if (l > r) {
36            return null;   
37        }
38        
39        // rules
40        // get the root
41        int rootval = postorder[index];
42        index--;
43        int mididx = map.get(rootval);
44        TreeNode root = new TreeNode(rootval);
45        
46        // divide
47        TreeNode ritree = dfs(postorder,mididx+1, r);
48        TreeNode letree = dfs(postorder, l, mididx-1);
49        root.right = ritree;
50        root.left = letree;
51        return root;    
52        
53    }
54    
55}
56/**
57inorder: left root right
58postorder: left right root
59
60 */