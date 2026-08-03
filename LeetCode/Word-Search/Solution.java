1class Solution {
2    private boolean res = false;
3    public boolean exist(char[][] board, String word) {
4        int m = board.length; // row
5        int n = board[0].length;
6
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                
10                dfs(board, word, 0, i, j);
11
12                
13
14            }
15
16        }
17        return res;
18        
19    }
20
21    private void dfs(char[][] board, String word, int idx, int row, int col) {
22        //base case
23        if (idx == word.length()) {
24           
25            res = true;
26            return;
27
28        }
29        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || idx > word.length() || board[row][col] == '#') {
30            return;// todo 
31
32        }
33
34        
35        char temp =  board[row][col];
36        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
37        if (word.charAt(idx) == board[row][col]) {
38            board[row][col] = '#';
39            for (int[] dir : dirs) {
40                int x = dir[0] + row;
41                int y = dir[1] + col;
42
43                dfs(board, word, idx+1, x, y);
44
45            }
46            board[row][col] = temp;
47        }
48   
49       
50    }
51}