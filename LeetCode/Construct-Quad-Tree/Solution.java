1/*
2// Definition for a QuadTree node.
3class Node {
4    public boolean val;
5    public boolean isLeaf;
6    public Node topLeft;
7    public Node topRight;
8    public Node bottomLeft;
9    public Node bottomRight;
10
11    
12    public Node() {
13        this.val = false;
14        this.isLeaf = false;
15        this.topLeft = null;
16        this.topRight = null;
17        this.bottomLeft = null;
18        this.bottomRight = null;
19    }
20    
21    public Node(boolean val, boolean isLeaf) {
22        this.val = val;
23        this.isLeaf = isLeaf;
24        this.topLeft = null;
25        this.topRight = null;
26        this.bottomLeft = null;
27        this.bottomRight = null;
28    }
29    
30    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
31        this.val = val;
32        this.isLeaf = isLeaf;
33        this.topLeft = topLeft;
34        this.topRight = topRight;
35        this.bottomLeft = bottomLeft;
36        this.bottomRight = bottomRight;
37    }
38}
39*/
40
41class Solution {
42    public Node construct(int[][] grid) {
43        int n = grid.length;
44        // edge case todo
45        return build(grid, n, 0, 0);   
46    }
47
48    private Node build(int[][] grid, int size, int i, int j) {
49        //base case
50        if (size == 1) {
51            boolean val = false;
52            if (grid[i][j] == 1) {
53                val = true;
54
55            }
56            Node newNode = new Node(val,true,null, null,null,null);
57            return newNode;
58        }
59        //break down
60        size = size / 2;
61        Node tL = build(grid,size, i,j );
62        Node tR = build(grid,size, i,j+size );
63        Node bL = build(grid,size, i+size,j);
64        Node bR = build(grid,size, i+size,j+size );
65        
66        
67        if (canMerge(tL, tR, bL, bR)) {
68            return new Node(tL.val,true,null, null,null,null);
69        } else {
70            return new Node(true,false,tL,tR,bL,bR);
71        }
72
73    }
74
75    // isLeaf
76    private boolean canMerge(Node tL, Node tR,Node bL,Node bR) {
77        if (tL.isLeaf == true && tR.isLeaf == true && bL.isLeaf == true && bR.isLeaf == true) {
78            boolean val = tL.val;
79            if (val == tR.val && bL.val == val && bR.val == val) {
80                return true;
81            }
82        }
83        return false;
84
85    }
86}