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
43        return rec(grid,0,0,grid.length);
44        
45    }
46
47    private Node rec(int[][] grid, int row, int col, int size) {
48        if (areSame(grid,row,col,size)) {
49            // all 1
50            if (grid[row][col] == 1) {
51                return new Node(true, true);
52
53            } else { // all 0
54                return new Node(false, true);
55
56            }
57        }
58        Node leaf = new Node(false, false);
59        
60        int half = size / 2;
61        
62        leaf.topLeft = rec(grid, row, col, half);
63        leaf.topRight = rec(grid, row, col+ half, half);
64        leaf.bottomLeft = rec(grid, row+ half, col, half);
65        leaf.bottomRight = rec(grid, row+half, col+half, half);
66        System.out.println(leaf);
67        
68        return leaf;
69
70    }
71
72    private boolean areSame(int[][]grid, int row, int col, int size) {
73        int base = grid[row][col];
74        for (int i = row; i < row+ size; i++) {
75            for (int j = col; j < col + size; j++) {
76                if (grid[i][j] != base) {
77                    return false;
78
79                }
80
81            }
82
83        }
84        return true;
85
86    }
87}
88
89
90/**
91val: boolean: 1  means true; 0 means false; if isLeaf is false, val can be true/false;
92isLeaf: true - leaf node ?  all values are same, val is relate to matrix value: if all 0, that means false; if all 1, that means true
93        false -  the node has four children,   set val to any value 
94
95
96check if all the matrix[i][j] are same?  return Node(true, value of matrix[i][j]) - helper function
97main logic : 
981. check if areSame(helper) // base case  
992. set isLeaf as (false, anything);
100- check 4 different parts to build the tree; // main
101
102recursion: i need know the start, end (range)
1031. base case leaf or not
1042. check each part (divided into 4 parts) (怎么拆)
1053. size = size /2, we divide the large square's hight by 2, grid[][], i need know the start, end (range): same width, height; （每个问题如何解决）
106 
107
108
109 */