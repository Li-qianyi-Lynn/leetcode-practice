1class LRUCache {
2    class Node {
3        Node prev;
4        Node next;
5        int key;
6        int val;
7
8        Node (int key, int val) {
9            this.key = key;
10            this.val = val;
11
12        }
13    }
14    HashMap<Integer,Node> map = new HashMap<>();
15    Node head = new Node (-1,-1);
16    Node tail = new Node (-1,-1);
17    int capacity = 0;
18
19    public LRUCache(int capacity) {
20        this.capacity = capacity;
21        head.next = tail;
22        tail.prev = head;
23        
24    }
25    
26    public int get(int key) {
27        if (!map.containsKey(key)) {
28            return -1;
29        }
30
31        Node cur = map.get(key);
32        detach(cur);
33        addToEnd(cur);
34        return cur.val;
35        
36    }
37    
38    public void put(int key, int value) {
39        if (map.containsKey(key)) {
40            Node cur = map.get(key);
41            cur.val = value;
42            detach(cur);
43            addToEnd(cur);
44            return;
45        } 
46
47        Node newNode = new Node(key,value);
48        map.put(key, newNode);
49        addToEnd(newNode);
50        if (map.size() > capacity) {
51            Node toRemove = head.next;
52            map.remove(toRemove.key);
53            detach(toRemove);
54        }
55        
56    }
57
58    private void detach(Node node) {
59        Node pre = node.prev;
60        Node nex = node.next;
61        pre.next = nex;
62        nex.prev = pre;
63
64
65    }
66
67    private void addToEnd(Node node) {
68        Node pre = tail.prev;
69        node.next = tail;
70        node.prev = pre;
71        pre.next = node;
72        tail.prev = node;
73
74
75
76    }
77}
78/**
79hashmap: key -> Node
80LinkedList  head -> cur->tail
81
82node
83
84 */
85/**
86 * Your LRUCache object will be instantiated and called as such:
87 * LRUCache obj = new LRUCache(capacity);
88 * int param_1 = obj.get(key);
89 * obj.put(key,value);
90 */