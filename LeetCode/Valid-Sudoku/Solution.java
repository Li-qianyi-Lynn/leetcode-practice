1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3
4        boolean[][] row = new boolean[9][9]; 
5        boolean[][] col = new boolean[9][9]; 
6        boolean[][] sq = new boolean[9][9]; 
7
8        for (int i = 0; i < 9; i++) {
9            for (int j = 0; j < 9; j++) {
10                char c = board[i][j];
11                if (c != '.') {
12                    int num = c - '1';
13                    int sqidx = (i / 3) * 3 + (j/3);
14                    if (row[i][num] || col[j][num] || sq[sqidx][num]) {
15                        return false;
16                    }
17                    row[i][num] = true;
18                    col[j][num] = true;
19                    sq[sqidx][num] = true;
20                }
21
22            }
23
24        }
25        return true;
26
27
28        
29        
30    }
31}
32
33/**
34boolean[][]
35
361.row/col/sq
37row : i
38col : j
39sq : sdidx (i/ 3) * 3 + j/3
40
412.char num : c - '1'-> 0-8
42
431. iterate board, get char and num
44  - char:
45     if any boolean arry is true, return false;
46
47  - . skip
48
49  update boolean arrys
50*/