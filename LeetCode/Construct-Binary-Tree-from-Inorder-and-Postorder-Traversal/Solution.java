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
17    private int rootidx;
18    public TreeNode buildTree(int[] inorder, int[] postorder) {
19        // to find treenode in left side and right side
20        Map<Integer, Integer> map = new HashMap<>();
21        for (int i = 0; i < inorder.length; i++) {
22            map.put(inorder[i],i);
23        }
24        // get the rootidx, it will be updated frequently in recursion, global value
25        rootidx = postorder.length-1;// rootidx in postorder
26        
27        return helper(map, 0, inorder.length-1, postorder);   
28    }
29    private TreeNode helper(Map<Integer, Integer> map, int leftStart, int rightEnd,int[] postorder) {
30        if (leftStart > rightEnd) {
31            return null;
32
33        }
34
35        int rootVal = postorder[rootidx];
36        rootidx--;
37        TreeNode root = new TreeNode(rootVal);
38
39        // need split 
40        int split = map.get(rootVal);
41        root.right = helper(map, split+1, rightEnd, postorder);
42        root.left = helper(map, leftStart, split-1, postorder);
43        return root;
44
45    }
46
47    
48}
49
50
51/**
52inorder : left root right -> find treenode in left side and right side
53postorder: left right root -> find root node
54
55find the root in an range and its child nodes
56map: inorder[i] -> index
57
58
59
60
61
62 */