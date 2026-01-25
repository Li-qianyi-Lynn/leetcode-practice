1class Node { // doubly linked List
2    int key;
3    int value;
4    Node prev;
5    Node next;
6    Node (int key, int value) {
7        this.key = key;
8        this.value = value;
9
10    }
11}
12
13class LRUCache {
14
15    private int capacity;
16    private Map<Integer, Node> map; // key -> node
17    private Node head;
18    private Node tail;
19
20    public LRUCache(int capacity) {
21        this.capacity = capacity;
22        this.map = new HashMap<>(); // map 初始化yaozhuyi
23        head = new Node(-1,-1);
24        tail = new Node(-1,-1);
25        head.next = tail;
26        tail.prev = head;
27
28        
29    }
30    
31    public int get(int key) {
32        // check if the map contains key, if no ,return -1; if yes ,we need return the value, and update the linkedList
33        // -get the node,return node.val
34        // -detach the node, and then add it to the end of the linkedList
35        if (!map.containsKey(key)) {
36            return -1;
37
38        }
39
40        Node node = map.get(key);
41        detach(node);
42        addtoEnd(node);
43
44        return node.value;
45        
46    }
47    
48    public void put(int key, int value) {
49        // check if the map contains key, if yes, update the node.value, detach the node; if no, put a new pair into the map, add the new node to the end of the linkedlist; if size > capacity, detach the first node 
50        if (map.containsKey(key)) {
51            Node node = map.get(key);
52            node.value = value;
53            detach(node);
54            addtoEnd(node);
55
56        } else {
57            Node newNode = new Node(key,value);
58            map.put(key,newNode);
59            addtoEnd(newNode);
60            if (map.size() > capacity) {
61                Node lru = head.next;
62                detach(lru);
63                map.remove(lru.key);
64            }
65        }
66        
67    }
68
69    private void detach(Node node) { // detach this node
70        Node preN = node.prev;
71        Node nextN = node.next;
72
73        preN.next = nextN;
74        nextN.prev = preN;
75
76    }
77
78    private void addtoEnd(Node node) {
79        Node tailPre = tail.prev;
80        
81        node.prev = tailPre;
82        node.next = tail;
83        tail.prev = node;
84        tailPre.next = node;
85
86
87    }
88}
89
90/**
91 * Your LRUCache object will be instantiated and called as such:
92 * LRUCache obj = new LRUCache(capacity);
93 * int param_1 = obj.get(key);
94 * obj.put(key,value);
95 */