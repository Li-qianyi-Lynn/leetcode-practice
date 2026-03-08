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
18        Map<Node, Node> map = new HashMap<>();
19        Node cur = head;
20        while (cur != null) {
21            map.put(cur, new Node(cur.val));
22            cur = cur.next;
23        }
24
25        cur = head;
26        while (cur != null) {
27            map.get(cur).next = map.get(cur.next);
28            map.get(cur).random = map.get(cur.random);
29            cur = cur.next;
30        }
31        return map.get(head);
32        
33    }
34}
35
36/**
37map:
381. copy: old node -> new node
39
402. set the connection
41
42
43 */