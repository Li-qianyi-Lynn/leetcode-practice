1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        neighbors = new ArrayList<Node>();
9    }
10    public Node(int _val) {
11        val = _val;
12        neighbors = new ArrayList<Node>();
13    }
14    public Node(int _val, ArrayList<Node> _neighbors) {
15        val = _val;
16        neighbors = _neighbors;
17    }
18}
19*/
20
21public class Solution {
22    public Node cloneGraph(Node node) {
23
24        if (node == null) {
25            return null;
26        }
27
28        Map<Node, Node> oldToNew = new HashMap<>();
29        
30        Deque<Node> dq = new ArrayDeque<>();
31
32        oldToNew.put(node, new Node(node.val));
33        dq.offer(node);
34
35        while (!dq.isEmpty()) {
36            Node curr = dq.poll();
37
38            for (Node nei : curr.neighbors) {
39                if (!oldToNew.containsKey(nei)) {
40                    oldToNew.put(nei, new Node(nei.val));
41                    dq.offer(nei);
42                }
43                
44                // 将克隆的邻居，连接到克隆的当前节点上
45                oldToNew.get(curr).neighbors.add(oldToNew.get(nei));
46            }
47        }
48
49        return oldToNew.get(node);
50
51
52    //     // old ： new
53    //     Map<Node, Node> oldToNew = new HashMap<>();
54
55
56    //     return dfs(node, oldToNew);
57    // }
58
59    // private Node dfs(Node node, Map<Node, Node> oldToNew) {
60    //     if (node == null) {
61    //         return null;
62
63    //     }
64    //     if (oldToNew.containsKey(node)) {
65    //         return oldToNew.get(node);
66
67    //     }
68
69    //     Node copy = new Node(node.val);
70    //     oldToNew.put(node, copy);
71
72    //     // add copy.neighbor
73    //     for (Node nei : node.neighbors) {
74    //         copy.neighbors.add(dfs(nei, oldToNew));
75
76    //     }
77
78    //     return copy;
79    // }
80
81    }
82
83    
84}
85
86/**
87dfs
88时间复杂度：$O(N + E)$，其中 $N$ 是节点数，$E$ 是边数。每个节点和每条边都会被访问一次。
89空间复杂度：$O(N)$。主要开销是 Map 存储 $N$ 个节点的映射，以及递归调用的栈深度。
90
91
92 */