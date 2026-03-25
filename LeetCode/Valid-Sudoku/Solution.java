1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3        int rows = board.length;
4        int cols = board[0].length;
5
6        boolean[][] row = new boolean[9][9]; 
7        boolean[][] col = new boolean[9][9]; 
8        boolean[][] sq = new boolean[9][9]; 
9
10        for (int i = 0; i < rows; i++) {
11            for (int j = 0; j < cols; j++) {
12                char c = board[i][j];
13                if (c != '.') {
14                    int num = c - '1';
15                    int sqidx = (i / 3) * 3 + (j/3);
16                    if (row[i][num] || col[j][num] || sq[sqidx][num]) {
17                        return false;
18                    }
19                    row[i][num] = true;
20                    col[j][num] = true;
21                    sq[sqidx][num] = true;
22                }
23
24            }
25
26        }
27        return true;
28
29
30        
31        
32    }
33}
34
35/**
36boolean[][]
37
381.row/col/sq
39row : i
40col : j
41sq : sdidx (i/ 3) * 3 + j/3
42
432.char num : c - '1'-> 0-8
44
451. iterate board, get char and num
46  - char:
47     if any boolean arry is true, return false;
48
49  - . skip
50
51  update boolean arrys
52*/