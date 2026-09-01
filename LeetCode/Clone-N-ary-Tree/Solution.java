1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> children;
6
7    
8    public Node() {
9        children = new ArrayList<Node>();
10    }
11    
12    public Node(int _val) {
13        val = _val;
14        children = new ArrayList<Node>();
15    }
16    
17    public Node(int _val,ArrayList<Node> _children) {
18        val = _val;
19        children = _children;
20    }
21};
22*/
23
24class Solution {
25    HashMap<Node, Node> map = new HashMap<>();
26    public Node cloneTree(Node root) {
27        if (root == null) {
28            return null;
29
30        }
31
32        if (map.containsKey(root)) {
33            return map.get(root);
34
35        }
36
37        Node newNode = new Node(root.val);
38        map.put(root, newNode);
39        if (!root.children.isEmpty()) {
40            List<Node> list = root.children;
41            for (int i = 0; i < list.size(); i++) {
42                newNode.children.add(cloneTree(list.get(i)));
43            }
44
45        }
46        return newNode;
47
48
49
50        
51    }
52}