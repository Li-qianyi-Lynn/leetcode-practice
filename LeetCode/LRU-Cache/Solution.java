1
2class LRUCache {
3    class Node {
4        int val;
5        int key;
6        Node prev;
7        Node next;
8
9        Node (int key, int val) {
10            this.key = key;
11            this.val = val;
12
13        }
14
15    }
16    int capacity;
17    Map<Integer, Node> map;
18    Node head = new Node (-1,-1);
19    Node tail = new Node (-1,-1);
20
21    public LRUCache(int capacity) {
22        this.capacity = capacity;
23        head.next = tail;
24        tail.prev = head;   
25        map = new HashMap<>(); 
26    }
27    
28    public int get(int key) {
29        if (map.containsKey(key)) {
30            Node cur = map.get(key);
31            detach(cur);
32            addToEnd(cur);
33            return cur.val;
34        }
35        return -1;
36        
37    }
38    
39    public void put(int key, int value) {
40        if (map.containsKey(key)) {
41            Node cur = map.get(key);
42            detach(cur);
43            cur.val = value;
44            addToEnd(cur);
45        } else {
46            Node newNode = new Node(key, value);
47            addToEnd(newNode);
48            map.put(key, newNode);
49    
50            if (map.size() > capacity) {
51                Node toRemove = head.next;
52                map.remove(toRemove.key);
53                detach(toRemove);
54
55            }
56        }
57
58        
59    }
60
61    private void detach(Node node) {
62        Node pre = node.prev;
63        Node nex = node.next;
64        pre.next = nex;
65        nex.prev = pre;
66
67    }
68
69    private void addToEnd(Node node) {
70        Node pre = tail.prev;
71        pre.next = node;
72        node.next = tail;
73        tail.prev=  node;
74        node.prev = pre;
75
76
77    }
78    /**
79    hashmap: key -> v
80    LinkedList:
81
82    head->cur-> tail
83    
84    node
85     */
86}
87
88/**
89 * Your LRUCache object will be instantiated and called as such:
90 * LRUCache obj = new LRUCache(capacity);
91 * int param_1 = obj.get(key);
92 * obj.put(key,value);
93 */