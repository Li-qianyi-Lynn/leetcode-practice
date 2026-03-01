1class Solution {
2    public void gameOfLife(int[][] board) {
3        int rows = board.length;
4        int cols = board[0].length;
5
6        int[] dires = new int[]{0,1,-1}; // 8 directions
7
8        for (int i = 0; i < rows; i++) {
9            for (int j = 0; j < cols; j++) {
10                int lived = 0;
11
12                for (int m = 0; m < 3; m++) {
13                    for (int n = 0; n < 3; n++) {
14                        if (!(dires[m] ==0 && dires[n] == 0)) {// 不同时为0
15                            int x = i+dires[m];
16                            int y = j+dires[n];
17
18                            if (x >= 0 && x < rows && y >= 0 && y < cols && (board[x][y] == 1 || board[x][y] == 3)) {
19                                lived++;
20
21                            }
22                        }    
23                    }
24                }
25                // live to die
26                if ((lived < 2 || lived > 3) && board[i][j] == 1) {
27                    board[i][j] = 3;
28
29                } 
30                // if ((lived ==2 || lived == 3) && board[i][j] == 1) {
31                //     board[i][j] =1;
32
33                // } 
34                if (lived == 3 && board[i][j] == 0) {
35                    board[i][j] = 2;
36
37                }
38
39            }
40
41        }
42
43        for (int i = 0; i < rows; i ++) {
44            for (int j = 0; j < cols; j++) {
45                if (board[i][j] == 2) {
46                    board[i][j] = 1;
47
48                } else if (board[i][j] == 3) {
49                    board[i][j] = 0;
50
51                }
52            }
53
54        }
55        
56    }
57}
58
59/**
600: died-> died
611: live -> live
622: died -> live
633: live -> died
64
651. for loop to check lived neibours, update the status
662. 2 for loop: 3 -> 0, 2-> 1
67
68
69
70
71 */