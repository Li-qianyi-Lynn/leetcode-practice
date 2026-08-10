1class Solution {
2    private int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}} ;
3
4        
5
6    public List<List<Integer>> pacificAtlantic(int[][] heights) {
7        List<List<Integer>> res = new ArrayList<>();
8     
9
10        int m = heights.length;
11        int n = heights[0].length;
12        boolean[][] canP = new boolean[m][n];
13        boolean[][] canA = new boolean[m][n];
14        
15       
16        for (int j = 0; j < n; j++) {
17             //pacific ocean first row
18            dfs(heights,canP,0,j,heights[0][j]); //todo
19            dfs(heights, canA, m-1, j, heights[m-1][j]);
20
21        }
22
23        for (int i = 0; i < m; i++) {
24            dfs(heights,canP,i,0,heights[i][0]);
25            dfs(heights,canA, i, n-1, heights[i][n-1]);
26
27        }
28
29        for (int i = 0; i < m; i++) {
30            for (int j = 0; j < n; j++) {
31                if (canP[i][j] && canA[i][j]) {
32                    res.add(new ArrayList<>(Arrays.asList(i, j)));
33                }
34
35            }
36
37        }
38        return res;
39
40
41        
42    }
43
44
45    private void dfs (int[][] heights, boolean[][] map, int r, int c, int preH) {
46        //base case
47        int m = heights.length;
48        int n = heights[0].length;
49        if (r < 0 || r >= m || c < 0 || c >= n || heights[r][c] < preH || map[r][c] == true) {
50            return;
51        }
52
53        map[r][c] = true;
54        // private int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}} ;
55        for (int[] dir : dirs) {
56            int x = dir[0] + r;
57            int y = dir[1] + c;
58       
59            dfs(heights, map, x,y, heights[r][c]);
60            
61        }
62
63
64    }
65}
66/**
67input: int[][] heights
68less than or equal to the current cell's height. from 4 dirs
69
70output: List<List<Integer>> 
71memo[p]
72memo[a]
73
74dfs -> 4dire
75cur height > preheight
76base case: 碰到边界
77
78 */