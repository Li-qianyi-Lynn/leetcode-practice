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
20        HashMap<Node, Node> map = new HashMap<>();
21        while (cur != null) {
22            map.put(cur, new Node(cur.val));
23            cur = cur.next;
24        }
25        cur = head;
26        while (cur != null) {
27            Node copyNode = map.get(cur);
28            copyNode.random = map.get(cur.random);
29            copyNode.next = map.get(cur.next);
30            cur = cur.next;
31        }
32
33        return map.get(head);
34       
35        
36    }
37}
38/**
39hashmap node -> copy node (val)
40node.random = map.get(node.random)
41node.next = map.get(node.next)
42
43
44
45
46 */