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
22    private HashMap<Node, Node> visited = new HashMap<>();
23    public Node cloneGraph(Node node) {
24        //base case
25        if (node == null) {
26            return null;
27        }
28
29        
30        if (visited.containsKey(node)) {
31            return visited.get(node);
32
33        }
34
35        Node cloneNode = new Node(node.val);
36        visited.put(node,cloneNode);
37        for (Node nei : node.neighbors) {
38            cloneNode.neighbors.add(cloneGraph(nei));
39
40        }
41        return cloneNode;
42        
43    }
44}
45/**
46clone 
47hashmap: old -> new 
48
49
50
51 */