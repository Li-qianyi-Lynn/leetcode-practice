1/**
2HashMap key-> Node
3doubly linkedList
4Node(key, value)
5
6
7(-1) <->(1) <-> (2) <->(3) <-> (-1)
8|                               |
9head.                          tail
10 */
11
12class LRUCache {
13    class Node {
14        int key, val;
15        Node prev, next;
16        Node(int key, int val) {
17            this.key = key;
18            this.val = val;
19
20        }
21    }
22
23    private int capacity;
24    private Map<Integer, Node> map;
25    private Node head;
26    private Node tail;
27
28    public LRUCache(int capacity) {
29        this.capacity = capacity;
30        this.map = new HashMap<>();
31        head = new Node(-1,-1);
32        tail = new Node(-1,-1);
33        head.next = tail;
34        tail.prev = head;
35            
36    }
37    // remove add
38    /**
39    
40    (-1) <->(1) <-> (2) <->(3) <-> (-1)
41    |                               |
42    head.                       tail
43    
44    
45     */
46
47    private void detach(Node node) {
48        Node preNode = node.prev;
49        Node nexNode = node.next;
50
51        preNode.next = nexNode;
52        nexNode.prev = preNode;
53
54        // node.prev.next = node.next;
55        // node.next.prev = node.prev;
56    }
57
58// 先插再改
59    private void add(Node node) {
60        node.prev = tail.prev;
61        node.next = tail;
62
63        tail.prev.next = node;
64        tail.prev = node;
65
66    }
67
68    public int get(int key) {
69        // not exist
70        if (!map.containsKey(key)) {
71            return -1;
72
73        }
74        // get the node 
75        Node node = map.get(key);
76        
77        detach(node);
78        add(node);
79        return node.val;
80        
81    }
82    
83    public void put(int key, int value) {
84        
85
86        if (map.containsKey(key)) {
87            Node node = map.get(key);
88            detach(node);
89            node.val = value;
90            add(node);
91           
92        } else {
93            
94            if (map.size() >= capacity) {
95                Node lru = head.next;
96                detach(lru);
97                map.remove(lru.key);
98
99            }
100             
101            Node newN = new Node(key, value);
102            map.put(key,newN);
103            add(newN);
104
105        }
106        
107    }
108}
109
110/**
111 * Your LRUCache object will be instantiated and called as such:
112 * LRUCache obj = new LRUCache(capacity);
113 * int param_1 = obj.get(key);
114 * obj.put(key,value);
115 */