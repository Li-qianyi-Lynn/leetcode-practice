1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3        // whether each row/cols/square has duplicated digits 1-9 
4        // the hardest point is how to locate square cols and rows
5        // square
6        for (int sqr = 0; sqr < 9; sqr++) {
7            Set <Character> seen = new HashSet<>();
8            for (int i = 0; i < 3; i++) {
9                for (int j = 0; j < 3; j++) {
10                    int row = (sqr / 3) * 3 +i;
11                    int col = (sqr % 3) * 3 +j;
12                    if (board[row][col] == '.' ) { continue;}
13                    if (seen.contains(board[row][col])) { return false;}
14                    seen.add(board[row][col]);
15
16                }
17
18            }
19        }
20
21        // rows
22        for (int row = 0; row < 9; row++) {
23            Set <Character> seen = new HashSet<>();
24            for (int i = 0; i < 9; i++) {
25                if (board[row][i] == '.') { continue;}
26                if (seen.contains(board[row][i])) { return false;}
27                    seen.add(board[row][i]);
28            }
29        }
30
31        for (int col = 0; col < 9; col++) {
32            Set <Character> seen = new HashSet<>();
33            for (int i = 0; i < 9; i++) {
34                if (board[i][col] == '.') { continue;}
35                if (seen.contains(board[i][col])) { return false;}
36                    seen.add(board[i][col]);
37            }
38
39
40        }
41        return true;
42
43
44        
45        
46    }
47}