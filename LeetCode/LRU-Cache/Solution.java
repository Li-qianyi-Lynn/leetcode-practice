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
12class Node {
13        int key, val;
14        Node prev, next;
15        Node(int key, int val) {
16            this.key = key;
17            this.val = val;
18
19        }
20    }
21class LRUCache {
22    
23
24    private int capacity;
25    private Map<Integer, Node> map;
26    private Node head;
27    private Node tail;
28
29    public LRUCache(int capacity) {
30        this.capacity = capacity;
31        this.map = new HashMap<>();
32        head = new Node(-1,-1);
33        tail = new Node(-1,-1);
34        head.next = tail;
35        tail.prev = head;
36            
37    }
38    // remove add
39    /**
40    
41    (-1) <->(1) <-> (2) <->(3) <-> (-1)
42    |                               |
43    head.                       tail
44    
45    
46     */
47
48    private void detach(Node node) {
49        Node preNode = node.prev;
50        Node nexNode = node.next;
51
52        preNode.next = nexNode;
53        nexNode.prev = preNode;
54
55        // node.prev.next = node.next;
56        // node.next.prev = node.prev;
57    }
58
59// 先插再改
60    private void add(Node node) {
61        node.prev = tail.prev;
62        node.next = tail;
63
64        tail.prev.next = node;
65        tail.prev = node;
66
67    }
68
69    public int get(int key) {
70        // not exist
71        if (!map.containsKey(key)) {
72            return -1;
73
74        }
75        // get the node 
76        Node node = map.get(key);
77        
78        detach(node);
79        add(node);
80        return node.val;
81        
82    }
83    
84    public void put(int key, int value) {
85        
86
87        if (map.containsKey(key)) {
88            Node node = map.get(key);
89            detach(node);
90            node.val = value;
91            add(node);
92           
93        } else {
94            
95            if (map.size() >= capacity) {
96                Node lru = head.next;
97                detach(lru);
98                map.remove(lru.key);
99
100            }
101             
102            Node newN = new Node(key, value);
103            map.put(key,newN);
104            add(newN);
105
106        }
107        
108    }
109}
110
111/**
112 * Your LRUCache object will be instantiated and called as such:
113 * LRUCache obj = new LRUCache(capacity);
114 * int param_1 = obj.get(key);
115 * obj.put(key,value);
116 */