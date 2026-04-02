1class Node {
2    int val, key;
3    Node pre, next;
4    Node (int key, int val) {
5        this.val = val;
6        this.key = key;
7
8    }
9
10}
11class LRUCache {
12    int capacity;
13    Node head = new Node (-1,-1);
14    Node tail = new Node (-1,-1);
15    Map<Integer, Node> map;
16
17    public LRUCache(int capacity) {
18        this.capacity = capacity;
19        head.next = tail;
20        tail.pre = head;
21        map = new HashMap<>();    
22    }
23    
24    public int get(int key) {
25        if (!map.containsKey(key)) {
26            return -1;
27        }
28        Node node = map.get(key);
29        detach(node);
30        addToEnd(node);
31        return node.val;  
32    }
33    
34    public void put(int key, int value) {
35        if (map.containsKey(key)) {
36            Node node = map.get(key);
37            node.val = value;
38            detach(node);
39            addToEnd(node);
40        } else {
41            // check capacity, new node
42            if (map.size() == capacity) {
43                Node toRemove = head.next;
44                detach(toRemove);
45                map.remove(toRemove.key);
46            }
47
48            Node newNode = new Node (key,value);
49            addToEnd(newNode);
50            map.put(key, newNode);
51        }
52        
53    }
54    private void addToEnd(Node node) {
55        Node prev = tail.pre;
56        tail.pre = node;
57        node.next = tail;
58        node.pre = prev;
59        prev.next = node;
60
61
62    }
63
64    private void detach(Node node) {
65        Node prev = node.pre;
66        Node nex = node.next;
67        prev.next = nex;
68        nex.pre = prev;
69
70    }
71}
72
73/**
74 * Your LRUCache object will be instantiated and called as such:
75 * LRUCache obj = new LRUCache(capacity);
76 * int param_1 = obj.get(key);
77 * obj.put(key,value);
78 */
79 /**
80 
81 map: key -> Node
82 doublyLinkedList: head <-> Node <-> tail
83                             node
84 
85  */