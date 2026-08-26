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
26         if (root == null) {
27            return root;
28        }
29
30        Deque<Node> dq = new ArrayDeque<>();
31        dq.offer(root);
32
33        while (!dq.isEmpty()) {
34            int size = dq.size();
35            
36            Node pre = null;
37            for (int i = 0; i < size; i++) {
38                Node cur = dq.pollFirst();
39                
40                if (pre != null) {
41                    pre.next = cur;
42                    
43                } 
44                pre = cur; 
45
46                if (cur.left != null) {
47                    dq.offerLast(cur.left);
48                }
49                if (cur.right != null) {
50                    dq.offerLast(cur.right);
51                }
52
53            }
54            pre.next = null;
55        }
56
57        return root;
58     
59    }
60        
61}