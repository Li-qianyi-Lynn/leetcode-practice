1/**
2 * Definition for Node.
3 * public class Node {
4 *     int val;
5 *     Node left;
6 *     Node right;
7 *     Node random;
8 *     Node() {}
9 *     Node(int val) { this.val = val; }
10 *     Node(int val, Node left, Node right, Node random) {
11 *         this.val = val;
12 *         this.left = left;
13 *         this.right = right;
14 *         this.random = random;
15 *     }
16 * }
17 */
18
19class Solution {
20    HashMap<Node, NodeCopy> map = new HashMap<>();
21    public NodeCopy copyRandomBinaryTree(Node root) {
22        if (root == null) {
23            return null;
24        }
25        if (map.containsKey(root)) {
26            return map.get(root);
27        }
28
29        NodeCopy newNode = new NodeCopy(root.val);
30        map.put(root, newNode);
31
32
33        newNode.random = copyRandomBinaryTree(root.random);
34        newNode.left = copyRandomBinaryTree(root.left);
35        newNode.right = copyRandomBinaryTree(root.right);
36
37        return newNode;
38        
39    }
40}
41/**
42hashMap: oldNode -> newNode
43dfs
44
45
46
47
48 */