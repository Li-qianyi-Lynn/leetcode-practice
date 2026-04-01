1class Node {
2    int key,val;
3    Node prev, next;
4    Node (int key, int val) {
5        this.key = key;
6        this.val = val;
7
8    }
9}
10
11class LRUCache {
12    /**
13    doubly linkedlist 
14    map: key -> node
15     */
16    Map<Integer, Node> map;
17    int capacity;
18    Node head;
19    Node tail;
20
21    public LRUCache(int capacity) {
22        this.capacity = capacity;
23        map= new HashMap<>();
24        head = new Node (-1,-1);
25        tail = new Node (-1,-1);
26        head.next = tail;
27        tail.prev = head;
28        
29    }
30    
31    public int get(int key) { // update linkedlist
32        // not exist
33        if (!map.containsKey(key)) {
34            return -1;
35        }
36        Node node = map.get(key);
37        detach(node);
38        addToEnd(node); //刚使用了放到最后
39
40        return node.val;
41        
42    }
43    
44    public void put(int key, int value) { //update linkedlist, map
45        if (!map.containsKey(key)) {
46            if (map.size() == capacity) {
47                Node toRemove = head.next;
48                detach(toRemove);
49                int removedKey = toRemove.key;
50                map.remove(removedKey);
51            }  
52            Node newNode = new Node(key, value);
53            map.put(key, newNode);
54            addToEnd(newNode); // 新节点直接加入末尾，不需要 detach
55        } else {
56            Node node = map.get(key);
57            node.val = value; 
58            detach(node);     
59            addToEnd(node);
60
61        }
62    
63        
64        
65    }
66
67    private void addToEnd(Node node) {// head->node1 ->node2->node3->tail.     node4
68        Node pre =tail.prev;
69        node.prev = pre;
70        pre.next = node;
71        node.next = tail;
72        tail.prev = node;
73
74    }
75
76    private void detach(Node node) {
77        Node pre = node.prev;
78        Node nex = node.next;
79        pre.next = nex;
80        nex.prev = pre;
81    }
82}
83
84/**
85 * Your LRUCache object will be instantiated and called as such:
86 * LRUCache obj = new LRUCache(capacity);
87 * int param_1 = obj.get(key);
88 * obj.put(key,value);
89 */