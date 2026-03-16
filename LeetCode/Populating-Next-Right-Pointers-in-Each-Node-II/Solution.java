1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public Node left;
6    public Node right;
7    public Node next;
8
9    public Node() {}
10    
11    public Node(int _val) {
12        val = _val;
13    }
14
15    public Node(int _val, Node _left, Node _right, Node _next) {
16        val = _val;
17        left = _left;
18        right = _right;
19        next = _next;
20    }
21};
22*/
23
24class Solution {
25    public Node connect(Node root) {
26        // edge case
27        if (root == null) {
28            return root;
29        }
30        Deque<Node> dq = new ArrayDeque<>();
31        
32        dq.offerLast(root);
33        while (!dq.isEmpty()) {
34            int size = dq.size();
35            Node pre = null; // to store the node proceed in previous round
36            for (int i= 0; i < size; i++) {
37                Node cur = dq.pollFirst();
38                if (pre != null) {
39                    pre.next = cur;
40                }
41                pre = cur;
42                if (cur.left != null) {
43                    dq.offerLast(cur.left);   
44                }
45                if (cur.right != null) {
46                    dq.offerLast(cur.right);   
47                }
48            }   
49        }
50        return root;
51        
52    }
53}