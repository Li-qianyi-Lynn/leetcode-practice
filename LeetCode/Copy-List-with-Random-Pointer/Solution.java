1/*
2// Definition for a Node.
3class Node {
4    int val;
5    Node next;
6    Node random;
7
8    public Node(int val) {
9        this.val = val;
10        this.next = null;
11        this.random = null;
12    }
13}
14*/
15
16class Solution {
17    public Node copyRandomList(Node head) {
18        // edge case
19        if (head == null) {
20            return null;   
21        }
22        // step1: Map: oldNode -> newNode(object)
23        Node cur = head;
24        Map<Node,Node> map = new HashMap<>();
25        while (cur != null) {
26            Node newNode = new Node(cur.val);
27            map.put(cur,newNode);
28            cur = cur.next;     
29        }
30        // step2: build connections
31        cur = head;
32        while (cur != null) {
33            if (cur.next != null) {
34                map.get(cur).next = map.get(cur.next);    
35            }
36            if (cur.random != null) {
37                map.get(cur).random = map.get(cur.random);   
38            }
39            cur = cur.next;   
40        }
41        return map.get(head);  
42    }
43}
44
45/**
46map:
471. copy: old node -> new node
48
492. set the connection
50
51
52 */