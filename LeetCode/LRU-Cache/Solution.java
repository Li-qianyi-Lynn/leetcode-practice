1class LRUCache {
2    class Node {
3        int key, val;
4        Node pre, nex;
5
6        Node (int key, int val) {
7            this.key = key;
8            this.val = val;
9        }
10    }
11
12    int capacity;
13    Map<Integer, Node> map;
14    Node head = new Node (-1,-1);
15    Node tail = new Node (-1,-1);
16
17    public LRUCache(int capacity) {
18        this.capacity = capacity;
19        head.nex = tail;
20        tail.pre = head;
21        map = new HashMap<>();
22        
23    }
24    
25    public int get(int key) {
26        if (!map.containsKey(key)) {
27            return -1;
28
29        }
30        Node node = map.get(key);
31        detach(node);
32        addToEnd(node);
33        return node.val;
34    }
35    
36    public void put(int key, int value) {
37
38        // 1) key: update value, update linkedlist 
39        if (map.containsKey(key)) {
40            Node node = map.get(key);
41            node.val = value;
42            detach(node);
43            addToEnd(node);
44        } else {
45        // 2) - check capacity if size = capacity, we need to remove lru node
46         //   - new Node, update the linkedlist and map
47            if (map.size()==capacity) {
48                Node toRemove = head.nex;
49                detach(toRemove);
50                map.remove(toRemove.key);
51
52            }
53            Node newNode = new Node(key,value);
54            map.put(key, newNode);
55            addToEnd(newNode);
56        }
57
58        
59    }
60
61    private void detach(Node node) {
62        // head <-> no1 <-> no2 <-> tail.    no3
63        Node prev = node.pre;
64        Node next = node.nex;
65        prev.nex = next;
66        next.pre = prev;
67    }
68
69    private void addToEnd(Node node) {
70        Node prev = tail.pre;
71        node.pre = prev;
72        node.nex = tail;
73        prev.nex = node;
74        tail.pre = node;
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
85 /**
86 
87 order matters -> linkedlist: doubly linkedlist check the position in O(1)
88 map: key -> key,value 
89
90 
91  */