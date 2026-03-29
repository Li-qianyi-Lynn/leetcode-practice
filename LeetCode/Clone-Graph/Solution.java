1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        neighbors = new ArrayList<Node>(); // the set of neighbors of a node in the graph
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
21class Solution {
22    public Node cloneGraph(Node node) {
23        if (node == null) {
24            return node;
25        }
26        // step1
27        Map<Node, Node> map = new HashMap<>();
28        map.put(node, new Node(node.val));
29
30        // step2 bfs deque->queue
31        Deque<Node> dq = new ArrayDeque<>();
32        dq.offerLast(node);
33        while (!dq.isEmpty()) {
34            Node cur = dq.pollFirst();
35            // process the neighbots
36            List<Node> neibors = cur.neighbors;
37            // for sanity check
38            if (neibors.size() == 0) {
39                continue;
40            }
41            for (Node nei : neibors) {
42                if (!map.containsKey(nei)) {
43                    map.put(nei, new Node(nei.val));
44                    dq.offerLast(nei);
45                }
46                // update the neibours
47                map.get(cur).neighbors.add(map.get(nei));
48            }
49
50        }
51        return map.get(node);
52        
53    }
54}
55/**
561. map: to store old Node and new node(val),cant copy the neibour directly
57
582. deal with the neibors: dfs/bfs
59dq-> cur node -> check if the nei (old node) in the map, if not that means we need to create one; otherwise we just link the node in the map with the cur node
60old -> new
611,[2,4] -> 1,[2,4]
622,[1,3] -> 2,empty
634,[1,3]
64
65
66[2,4]
67use bfs to process 2 and 4 
68add 2 to the dq, update the map
69
70
71
72 */