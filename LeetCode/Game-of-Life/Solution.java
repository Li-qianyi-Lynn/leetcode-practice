1class Solution {
2    public void gameOfLife(int[][] board) {
3
4        int m = board.length; //rows
5        int n = board[0].length; // cols
6
7        int[] dirs = new int[]{-1,0,1};
8
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < n; j++) {
11                int lived = 0;
12                // iterate 8 dirs
13                for (int a= 0; a < 3; a++) {
14                    for (int b = 0; b < 3; b++) {
15                        if (!(dirs[a] == 0 && dirs[b] == 0)) {
16                            int x = i + dirs[a];
17                            int y = j + dirs[b];
18                            if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == -1)) {
19                                lived++;
20                            }
21                        }
22                    }
23                }
24// live to died -1 | nei 1 <= 2 ; nei > 3
25// die to live 2 | nei 1 == 3
26// live to live 1 |  nei 1 == 2/3
27                if (board[i][j] == 1 && (lived < 2 || lived > 3)) {
28                    board[i][j] = -1;
29                }
30
31                if (board[i][j] == 0 && lived == 3) {
32                    board[i][j] = 2;
33                }
34
35            }
36
37        }
38        for (int i = 0; i < m; i++) {
39            for (int j = 0; j < n; j++) {
40                if (board[i][j] == -1) {
41                    board[i][j] = 0;
42
43                } else if (board[i][j] == 2) {
44                    board[i][j] = 1;
45
46                }
47
48            }
49
50        }
51
52        // after for loop: -1 -> 0
53        //2 -> 1
54
55
56
57        
58    }
59}
60/**
61
62live to died -1 | nei 1 <= 2 ; nei > 3
63die to live 2 | nei 1 == 3
64live to live 1 |  nei 1 == 2/3
65die to die 0
66
67
68
69
70 */