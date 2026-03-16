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
26        if (root == null) {return root;}
27        Deque<Node> deque = new LinkedList<>();
28
29        deque.offerLast(root);
30        while (!deque.isEmpty()) {
31            int size = deque.size();
32            Node pre = null;
33            for (int i = 1; i <= size; i++) {
34                Node cur = deque.pollFirst();
35                if (cur.left != null) {deque.offerLast(cur.left);}
36                if (cur.right != null) {deque.offerLast(cur.right);}
37
38                if (pre != null) {pre.next = cur;}
39                pre = cur;
40
41            }
42
43        }
44        return root;
45
46        
47    }
48}