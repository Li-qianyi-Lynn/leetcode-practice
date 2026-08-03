1class Solution {
2    int[][] dires = new int[][]{{0,1},{0, -1},{-1,0},{1,0}};
3    public boolean exist(char[][] board, String word) {
4        int m = board.length; //row
5        int n = board[0].length; // col
6
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                if (board[i][j] == word.charAt(0)){ 
10                    if (dfs(board, i, j, 0, word)) {
11                        return true;
12
13                    }
14                }
15            }
16        }
17        return false;
18        
19    }
20
21    private boolean dfs(char[][] board, int row, int col, int idx, String word) {
22        // base case : check out of range
23        int m = board.length;
24        int n = board[0].length; // col
25
26      
27        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word.charAt(idx)) {
28            return false;
29        }
30        if (board[row][col] == '#') {
31            return false;
32        }
33        if (idx == word.length() -1) {
34            return true;
35        }
36        char temp = board[row][col];
37        board[row][col] = '#';
38
39        for (int[] dir : dires) {
40            int x = row + dir[0]; 
41            int y = col + dir[1];
42
43            if (dfs(board, x, y, idx+1, word)) {
44                board[row][col] = temp;
45                return true;
46            }
47        }
48        board[row][col] = temp;
49        return false;
50
51
52    }
53
54
55}
56
57/**
58
59input: char[][] board, string word
60output: boolean
61
62adjacent cells int[][]dirs
63not be used more than once: change visited to #
64
65dfs + int[][]dirs
66 */