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
43        return helper(grid, 0, 0, grid.length);
44    }
45
46    private Node helper(int[][] grid, int r, int c, int size) {
47        // 1. 检查当前区域是否所有值都相同
48        if (isAllSame(grid, r, c, size)) {
49            // 如果相同，创建一个叶子节点
50            // grid[r][c] == 1 表示 true，0 表示 false
51            return new Node(grid[r][c] == 1, true);
52        }
53
54        // 2. 如果不相同，创建一个非叶子节点，并递归拆分
55        Node node = new Node(true, false); // val 可以随便设，isLeaf 设为 false
56        int half = size / 2;
57
58        node.topLeft = helper(grid, r, c, half);
59        node.topRight = helper(grid, r, c + half, half);
60        node.bottomLeft = helper(grid, r + half, c, half);
61        node.bottomRight = helper(grid, r + half, c + half, half);
62
63        return node;
64    }
65
66    private boolean isAllSame(int[][] grid, int r, int c, int size) {
67        int val = grid[r][c];
68        for (int i = r; i < r + size; i++) {
69            for (int j = c; j < c + size; j++) {
70                if (grid[i][j] != val) {
71                    return false;
72                }
73            }
74        }
75        return true;
76    }
77}