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
26        if (root == null) {
27            return root;
28
29        }
30        Node cur = root;
31        while (cur != null) {
32            Node dummy = new Node(0);
33            Node p = dummy;
34
35            while (cur != null) {
36                if (cur.left != null) {
37                    p.next = cur.left;
38                    p = p.next;
39                }
40                if (cur.right != null) {
41                    p.next = cur.right;
42                    p = p.next;
43                }
44               
45                cur = cur.next;
46            }
47            
48            cur = dummy.next;
49
50        }
51        return root;
52        
53        
54    }
55}