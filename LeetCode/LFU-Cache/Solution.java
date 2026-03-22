1class LFUCache {
2    class Node {
3        int key, val, freq;
4        Node prev, next;
5        Node(int k, int v) {
6            this.key = k;
7            this.val = v;
8            this.freq = 1;
9        }
10    }
11
12    class DoubleLinkedList {
13        Node head, tail;
14        DoubleLinkedList() {
15            head = new Node(-1, -1);
16            tail = new Node(-1, -1);
17            head.next = tail;
18            tail.prev = head;
19        }
20
21        void addFirst(Node node) {
22            node.next = head.next;
23            node.prev = head;
24            head.next.prev = node;
25            head.next = node;
26        }
27
28        void remove(Node node) {
29            node.prev.next = node.next;
30            node.next.prev = node.prev;
31        }
32
33        Node removeLast() {
34            if (isEmpty()) return null;
35            Node res = tail.prev;
36            remove(res);
37            return res;
38        }
39
40        // 核心替代逻辑：通过判断哨兵节点连接情况来确定是否为空
41        boolean isEmpty() {
42            return head.next == tail;
43        }
44    }
45
46    Map<Integer, Node> cache;
47    Map<Integer, DoubleLinkedList> freqMap;
48    int capacity;
49    int minFreq;
50
51    public LFUCache(int capacity) {
52        this.capacity = capacity;
53        this.cache = new HashMap<>();
54        this.freqMap = new HashMap<>();
55        this.minFreq = 0;
56    }
57
58    public int get(int key) {
59        if (!cache.containsKey(key)) return -1;
60        Node node = cache.get(key);
61        updateFreq(node);
62        return node.val;
63    }
64
65    public void put(int key, int value) {
66        if (capacity == 0) return;
67        if (cache.containsKey(key)) {
68            Node node = cache.get(key);
69            node.val = value;
70            updateFreq(node);
71        } else {
72            if (cache.size() == capacity) {
73                // 利用 isEmpty() 逻辑找到 minFreq 对应的桶并删除末尾
74                Node toRemove = freqMap.get(minFreq).removeLast();
75                cache.remove(toRemove.key);
76            }
77            Node newNode = new Node(key, value);
78            cache.put(key, newNode);
79            minFreq = 1;
80            freqMap.computeIfAbsent(1, k -> new DoubleLinkedList()).addFirst(newNode);
81        }
82    }
83
84    private void updateFreq(Node node) {
85        int oldFreq = node.freq;
86        DoubleLinkedList oldList = freqMap.get(oldFreq);
87        oldList.remove(node);
88        
89        // 关键变化：直接检查 oldList 是否为空
90        if (oldFreq == minFreq && oldList.isEmpty()) {
91            minFreq++;
92        }
93
94        node.freq++;
95        freqMap.computeIfAbsent(node.freq, k -> new DoubleLinkedList()).addFirst(node);
96    }
97}
98
99/**
100 * Your LFUCache object will be instantiated and called as such:
101 * LFUCache obj = new LFUCache(capacity);
102 * int param_1 = obj.get(key);
103 * obj.put(key,value);
104 */