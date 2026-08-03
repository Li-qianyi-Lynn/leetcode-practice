1class Solution {
2    private int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
3    public boolean exist(char[][] board, String word) {
4        int m = board.length; // row
5        int n = board[0].length;
6
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                
10                if (dfs(board, word, 0, i, j)) {
11                    return true;
12                }
13
14            }
15
16        }
17        return false;
18        
19    }
20
21    private boolean dfs(char[][] board, String word, int idx, int row, int col) {
22        //base case
23        if (idx == word.length()) {
24            return true;
25
26        }
27        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || idx > word.length() || board[row][col] != word.charAt(idx)) {
28            return false;// todo 
29
30        }
31
32        
33        char temp =  board[row][col];
34        board[row][col] = '#';
35        
36        for (int[] dir : dirs) {
37            int x = dir[0] + row;
38            int y = dir[1] + col;
39
40            if (dfs(board, word, idx+1, x, y)) {
41                board[row][col] = temp;
42                return true;
43            }
44
45        }
46            
47    
48        board[row][col] = temp;
49        return false;
50   
51       
52    }
53}