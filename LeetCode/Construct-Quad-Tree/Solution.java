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
43        //puring?
44        return rec(grid,grid.length,0,0);
45        
46    }
47    private Node rec(int[][] grid, int size, int r, int c) {
48        if (isSame(grid,r,c,size)) {
49            if (grid[r][c] == 0) {
50                return new Node (false, true);
51
52            } else {
53                return new Node (true, true);
54            }
55
56        }
57        Node leaf = new Node (false, false);
58        size = size / 2;
59        leaf.topLeft = rec(grid, size, r, c);
60        leaf.topRight = rec(grid, size, r, c+size);
61        leaf.bottomLeft = rec(grid, size, r+size, c);
62        leaf.bottomRight = rec(grid, size, r+size, c+size);
63
64        return leaf;
65
66    }
67
68    private boolean isSame(int[][] grid, int r, int c, int size) {
69        int check = grid[r][c];
70        for (int i = r; i < r+size; i++) {
71            for (int j = c; j < c+size; j++ ) {
72                if (grid[i][j] != check) {
73                    return false;
74                }
75            }
76        }
77        return true;
78
79    }
80}
81
82/**
83helper function: 
841. same or not? 2 for loops check grid[i][j] is equal to grid[base][base] or not?
852. recursion: 划分4个区域进行递归
86
87- all same return new node ( grid[0][0] == 1 true; grid[0][0] == 0 false, true) c
88- not same 
89    - new node (true, false)
90
91    拆分！
92
93    node topLeft
94    Node topRight
95    Node bottomLeft
96    Node bottomRight
97
98    return node
99
100 */