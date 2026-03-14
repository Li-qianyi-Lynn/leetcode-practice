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
19        //node val -> index
20        Map<Integer, Integer> map = new HashMap<>();
21        for (int i = 0; i < inorder.length; i++) {
22            map.put(inorder[i], i);
23        }
24
25        rootidx = postorder.length-1; 
26        //contruct trees
27
28        return helper(map, 0, inorder.length-1, postorder);     // todo
29    }
30
31    private TreeNode helper(Map<Integer, Integer> map, int leftStart, int rightStart, int[] postorder) { //?
32        //base case
33        if (leftStart > rightStart) {
34            return null;
35        }
36
37        int rootVal = postorder[rootidx];
38        TreeNode root = new TreeNode(rootVal);
39        rootidx --; //processed this root
40
41        // get root idx in inorder
42        int split = map.get(rootVal);
43        root.right = helper(map, split+1, rightStart, postorder);
44        root.left = helper(map, leftStart, split-1, postorder);
45
46        return root;
47    }
48}
49/**
50input:
51inorder[] the inorder traversal of a binary tree: left root right; to find the right side and left side
52postorder[]: left right root; last index in the int[] is the root.val
53
54root - index
55map: node val -> index
56
57use recursion to construct the binary tree
58 [9 , 3, 15, 20, 7]
59     root.   
60 lp             
61                rp
621. base case: lp > rp return 
632. root: postorder[]
64root.right 
65root.left
66 */