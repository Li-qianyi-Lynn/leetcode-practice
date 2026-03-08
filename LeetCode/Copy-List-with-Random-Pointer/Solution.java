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
18        Node cur = head;
19
20        Map<Node, Node> map = new HashMap<>();
21        while (cur != null) {
22            map.put(cur, new Node(cur.val));
23            cur = cur.next;
24
25        }
26
27        cur = head;
28        while(cur != null) {
29            map.get(cur).next = map.get(cur.next);
30            map.get(cur).random = map.get(cur.random);
31            cur = cur.next;
32        }
33        return map.get(head);
34        
35        
36    }
37}
38
39/**
40copy the original list, we have the random pointer
41we can not link directly (not build it)
42
43use map
44oldNode -> newNode getthe val to build new node
45
46map.get(oldNode).next/random
47
48
49
50
51
52 */