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
18        if (head == null) return null;
19        Node cur = head;
20        while (cur != null) {
21            Node newNode = new Node (cur.val);
22            newNode.next = cur.next;
23            cur.next = newNode;
24            cur = newNode.next;
25           
26        }
27        cur = head;
28        while (cur != null) {
29            if (cur.random != null) {
30                cur.next.random = cur.random.next;
31            }
32            cur = cur.next.next;
33        }
34        cur = head;
35        Node dummyHead = new Node(0);
36        Node copyCur = dummyHead;
37
38        while (cur != null) {
39            Node copy = cur.next;
40            cur.next = copy.next;
41            copyCur.next = copy;
42            copyCur = copy;
43            cur = cur.next;
44        }
45
46        return dummyHead.next;
47        
48    }
49}
50/**
51hashmap node -> copy node (val)
52node.random = map.get(node.random)
53node.next = map.get(node.next)
54
55
56
57
58 */