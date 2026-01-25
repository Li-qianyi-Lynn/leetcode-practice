1class Node {
2    int key, val;
3    Node prev, next; // why
4    Node (int key, int val) {
5        this.key = key;
6        this.val = val;
7    }
8}
9class LRUCache {
10    private int capacity;
11    private Map<Integer, Node> map;
12    private Node head;
13    private Node tail;
14  
15    public LRUCache(int capacity) {
16        this.capacity = capacity;
17        this.map = new HashMap<>();
18        head = new Node(-1,-1);
19        tail = new Node(-1,-1);
20
21        head.next = tail;
22        tail.prev = head;
23        
24    }
25    
26    public int get(int key) {
27        if (!map.containsKey(key)) {
28            return -1;
29
30        } else {
31            Node node = map.get(key);
32            detach(node);
33            addToEnd(node);
34
35            return node.val;
36        }
37        
38    }
39    
40    public void put(int key, int value) {
41        if (map.containsKey(key)) {
42            Node node = map.get(key);
43            node.val = value;
44            detach(node);
45            addToEnd(node);
46
47        } else {
48            Node newNode = new Node(key,value);
49            map.put(key,newNode);
50            addToEnd(newNode);
51            if (map.size() > capacity) {
52                Node lru = head.next;
53                detach(lru);
54                map.remove(lru.key);
55
56            }
57        }
58        
59    }
60
61    private void detach(Node node) {
62        Node preNode = node.prev;
63        Node nextNode = node.next;
64
65        preNode.next =nextNode;
66        nextNode.prev = preNode;
67
68    }
69
70    private void addToEnd(Node node) {
71        Node tailPre = tail.prev;
72
73        node.prev = tailPre;
74        node.next = tail;
75        tailPre.next = node;
76        tail.prev = node;
77
78    }
79}
80
81/**
82doubly linked list : node - > key,val prev next
83Map: Integer, Node key -> Node
84dummy head: head, tail
85
86addToEnd
87detach
88
89
90 */
91/**
92 * Your LRUCache object will be instantiated and called as such:
93 * LRUCache obj = new LRUCache(capacity);
94 * int param_1 = obj.get(key);
95 * obj.put(key,value);
96 */