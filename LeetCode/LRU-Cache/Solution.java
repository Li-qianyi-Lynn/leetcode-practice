1class Node {
2    int val, key;
3    Node next;
4    Node pre;
5    Node (int key, int val) {
6        this.val = val;
7        this.key = key;
8
9    }
10}
11class LRUCache {
12    Node head;
13    Node tail;
14    Map<Integer,Node> map;
15    int capacity = 0;
16
17    public LRUCache(int capacity) {
18        head = new Node(-1,-1);
19        tail = new Node(-1,-1);
20        this.map = new HashMap<>();
21        head.next = tail;
22        tail.pre = head;
23        this.capacity = capacity;
24        
25    }
26    
27    public int get(int key) {
28        if (!map.containsKey(key)) {
29            return -1;
30        }
31        Node cur = map.get(key);
32        detach(cur);
33        addtoEnd(cur);
34        return cur.val;
35        
36    }
37    
38    public void put(int key, int value) {
39        if (map.containsKey(key)) {
40            Node cur = map.get(key);
41            detach(cur);
42            cur.val = value;
43            addtoEnd(cur);
44        } else { // update capacity
45            Node newNode = new Node(key,value);
46            map.put(key,newNode);
47            addtoEnd(newNode);
48            if (map.size()> capacity) {
49                Node lru = head.next;
50                detach(lru);
51                map.remove(lru.key);
52            }
53
54        }
55        
56    }
57
58    private void detach(Node node) {
59        Node preNode = node.pre;
60        Node nextNode = node.next;
61        preNode.next = nextNode;
62        nextNode.pre = preNode;
63
64    }
65
66    private void addtoEnd(Node node) {
67        // add to the tail.pre
68        Node preNode = tail.pre;
69        
70        preNode.next = node;
71        node.pre = preNode;
72        node.next = tail;
73        tail.pre = node;
74
75
76    }
77}
78
79/**
80 * Your LRUCache object will be instantiated and called as such:
81 * LRUCache obj = new LRUCache(capacity);
82 * int param_1 = obj.get(key);
83 * obj.put(key,value);
84 */
85
86 /**
87 map: key value
88 LinkedList: key
89 
90 
91  */