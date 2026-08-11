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
23        // old ： new
24        Map<Node, Node> oldToNew = new HashMap<>();
25
26
27        return dfs(node, oldToNew);
28    }
29
30    private Node dfs(Node node, Map<Node, Node> oldToNew) {
31        if (node == null) {
32            return null;
33
34        }
35        if (oldToNew.containsKey(node)) {
36            return oldToNew.get(node);
37
38        }
39
40        Node copy = new Node(node.val);
41        oldToNew.put(node, copy);
42
43        // add copy.neighbor
44        for (Node nei : node.neighbors) {
45            copy.neighbors.add(dfs(nei, oldToNew));
46
47        }
48
49        return copy;
50    }
51
52    
53}