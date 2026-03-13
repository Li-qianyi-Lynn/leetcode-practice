1class Node {
2    int key, val;
3    Node pre, next;
4    Node (int key, int val) {
5        this.key = key;
6        this.val = val;   
7    }
8    
9}
10
11class LRUCache {
12    int capacity;
13    Node head = new Node(-1,-1);
14    Node tail = new Node(-1,-1);
15    Map<Integer, Node> map;
16    
17    LRUCache(int capacity) {
18        this.capacity = capacity;
19        head.next = tail;
20        tail.pre = head;
21        map = new HashMap<>();
22    
23    }
24    
25    public int get(int key) {
26        //if exist return the value; or -1
27        if (!map.containsKey(key)) {
28            return -1;
29            
30        }
31        // update the linkedlist(order)
32        Node cur = map.get(key);
33        detach(cur);
34        addtoEnd(cur);
35        // return the value
36        return cur.val;
37    
38    }
39
40    public void put(int key, int value) {
41//         update the val(key exist)
42// or add the key-valu pair to the cache, if num of keys more than capacity , removed lrued keys
43        
44        if (map.containsKey(key)) {
45            Node cur = map.get(key);
46            // update the val
47            cur.val = value;
48            detach(cur);
49            addtoEnd(cur);   
50        } else {
51            Node newNode = new Node(key,value);
52            map.put(key, newNode);
53            addtoEnd(newNode);
54            // check if the size > capacity
55            if (map.size() > capacity) {
56                Node lruNode = head.next;
57                detach(lruNode);
58                map.remove(lruNode.key);   
59            }
60        }
61    }
62   
63    //detach node  head->1,1->2,2->3,3-> tail
64    private void detach(Node node) {
65        Node pre = node.pre;
66        Node nex = node.next;
67        
68        pre.next = nex;
69        nex.pre = pre;     
70    }
71    
72    
73    
74    //add the node to the end 
75    private void addtoEnd(Node node) {
76        // add the node before the tail node
77        Node preTail = tail.pre;
78        preTail.next = node;
79        node.next = tail;
80        tail.pre = node;
81        node.pre = preTail;      
82        
83    }
84
85}
86
87/**
88 * Your LRUCache object will be instantiated and called as such:
89 * LRUCache obj = new LRUCache(capacity);
90 * int param_1 = obj.get(key);
91 * obj.put(key,value);
92 */