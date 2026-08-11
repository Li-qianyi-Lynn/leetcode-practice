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
21class Solution {
22    public Node cloneGraph(Node node) {
23        if (node == null) {
24            return null;
25        }
26        Map<Node, Node> map = new HashMap<>();
27        map.put(node, new Node(node.val));
28        Deque<Node> dq = new ArrayDeque<>();
29        dq.offerLast(node);
30        while (!dq.isEmpty()) {
31            Node cur = dq.pollFirst();
32            for (Node nei : cur.neighbors) {
33                if (!map.containsKey(nei)) {
34                    map.put(nei, new Node(nei.val));
35                    dq.offer(nei);
36                }
37                map.get(cur).neighbors.add(map.get(nei));
38            }
39        }
40        return map.get(node);
41        
42    }
43}