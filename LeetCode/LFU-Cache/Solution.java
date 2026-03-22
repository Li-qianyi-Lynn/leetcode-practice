1class Node {
2    int key, val, freq; // 1. 增加了 freq
3    Node pre, next;
4    Node(int key, int val) {
5        this.key = key;
6        this.val = val;
7        this.freq = 1; // 新节点初始频率为 1
8    }
9}
10
11// 把你原来的 head/tail 逻辑封装成一个内部类，方便管理不同频率的桶
12class DoubleLinkedList {
13    Node head = new Node(-1, -1);
14    Node tail = new Node(-1, -1);
15    
16    DoubleLinkedList() {
17        head.next = tail;
18        tail.pre = head;
19    }
20
21    void addtoEnd(Node node) {
22        Node preTail = tail.pre;
23        preTail.next = node;
24        node.next = tail;
25        node.pre = preTail;
26        tail.pre = node;
27    }
28
29    void detach(Node node) {
30        node.pre.next = node.next;
31        node.next.pre = node.pre;
32    }
33
34    boolean isEmpty() {
35        return head.next == tail; // 当这个fre bucket 空的时候，更新minFreq
36    }
37}
38
39class LFUCache {
40    int capacity;
41    int minFreq; // 记录当前最小频率
42    Map<Integer, Node> map; //cache
43    Map<Integer, DoubleLinkedList> freqMap; // 频率 -> 该频率下的双向链表
44
45    public LFUCache(int capacity) {
46        this.capacity = capacity;
47        this.minFreq = 0;
48        this.map = new HashMap<>();
49        this.freqMap = new HashMap<>();
50    }
51
52    public int get(int key) {
53        if (!map.containsKey(key)) return -1;
54        Node cur = map.get(key);
55        updateFreq(cur); // 频率升级逻辑
56        return cur.val;
57    }
58
59    public void put(int key, int value) {
60        if (capacity == 0) return;
61
62        if (map.containsKey(key)) {
63            Node cur = map.get(key);
64            cur.val = value;
65            updateFreq(cur);
66        } else {
67            // 如果满了，先淘汰
68            if (map.size() >= capacity) {
69                DoubleLinkedList minList = freqMap.get(minFreq);
70                Node toRemove = minList.head.next; // LFU 规则：踢掉最小频率桶里最旧的（head.next）
71                minList.detach(toRemove);
72                map.remove(toRemove.key);
73                // 注意：这里不需要判断 minList 是否为空，因为马上就要加新节点，minFreq 会重置为 1
74            }
75            
76            // 插入新节点
77            Node newNode = new Node(key, value);
78            map.put(key, newNode);
79            minFreq = 1; // 新人进来，最小频率肯定是 1
80            freqMap.computeIfAbsent(1, k -> new DoubleLinkedList()).addtoEnd(newNode);
81        }
82    }
83
84    // 这是 LFU 的核心：把节点从旧频率桶挪到新频率桶
85    private void updateFreq(Node node) {
86        int oldFreq = node.freq;
87        DoubleLinkedList oldList = freqMap.get(oldFreq);
88        oldList.detach(node);
89
90        node.freq++;
91        // 如果当前桶是最小频率桶且空了，minFreq 增加
92        if (oldFreq == minFreq && oldList.isEmpty()) {
93            minFreq++;
94        }
95
96        
97        freqMap.computeIfAbsent(node.freq, k -> new DoubleLinkedList()).addtoEnd(node);
98    }
99}
100
101/**
102 * Your LFUCache object will be instantiated and called as such:
103 * LFUCache obj = new LFUCache(capacity);
104 * int param_1 = obj.get(key);
105 * obj.put(key,value);
106 */