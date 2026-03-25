1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3        Set<String> seen = new HashSet<>();
4        int rows = board.length;
5        int cols = board[0].length;
6        for (int i = 0; i < rows; i++) {
7            for (int j = 0; j < cols; j++) {
8                char c = board[i][j];
9                if (c != '.') {
10                    if (!seen.add(i + "row" + c) || 
11                    !seen.add(j + "col" + c) ||
12                    !seen.add(i/3 + "-" + j/3 + "sq" + c)) {
13                        return false;
14                    }
15                }
16            }
17        }
18        return true;
19        
20    }
21}
22
23/**
24set(): char + row/col/sq + i/j/ box
25row i
26col j
27square i/3 - j/3
28
290-0
300-1
310-2
32
331-0
341-1
351-2
36
372-0
382-1
392-2
40
41
421. iterate
432. check set.add(): 
44 false :has dups, return false
45 true: no worries
46 */