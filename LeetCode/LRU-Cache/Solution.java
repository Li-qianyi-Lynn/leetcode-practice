1class Node {
2    int key,val;
3    Node pre, next;
4    Node (int key, int val) {
5        this.key = key;
6        this.val = val;
7
8    }
9}
10class LRUCache {
11    Map<Integer, Node> map;
12    Node head;
13    Node tail;
14    int capacity;
15
16
17    public LRUCache(int capacity) {
18        map = new HashMap<>();
19        head = new Node(-1,-1);
20        tail = new Node(-1,-1);
21        this.capacity = capacity;
22        head.next = tail;
23        tail.pre = head;
24    
25    }
26    
27    public int get(int key) {
28        // use hashmap to check, when used key, update linkedlist
29        // detach
30        // add to the end
31        if (!map.containsKey(key)) {
32            return -1;
33
34        }
35
36        Node cur = map.get(key);
37        detach(cur);
38        addtoEnd(cur);
39        return cur.val;
40        
41    }
42    
43    public void put(int key, int value) {
44        if (map.containsKey(key)) {
45            Node cur = map.get(key);
46            cur.val = value;
47            detach(cur);
48            addtoEnd(cur);
49
50        } else {
51            Node newNode = new Node(key,value);
52            map.put(key, newNode);
53            addtoEnd(newNode);
54
55            if (map.size()> capacity) {
56                Node removed = head.next;
57                detach(removed);
58                map.remove(removed.key);
59            }
60        }
61
62        
63    }
64
65    private void detach(Node node) {
66        Node prev = node.pre;
67        Node nex = node.next;
68
69        prev.next = nex;
70        nex.pre = prev;
71
72    }
73
74    private void addtoEnd(Node node) {
75        Node tailbefore = tail.pre;
76        tailbefore.next = node;
77        node.next = tail;
78        tail.pre = node;
79        node.pre = tailbefore;
80
81        // 1,1 -> 2,2 -> tail
82
83    }
84}
85
86/**
87 * Your LRUCache object will be instantiated and called as such:
88 * LRUCache obj = new LRUCache(capacity);
89 * int param_1 = obj.get(key);
90 * obj.put(key,value);
91 */
92
93 /**
94 hashmap key -> node
95 doubly linkedlist
96 node
97
98 
99 
100  */