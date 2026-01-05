1class Solution {
2    public int minimumOperationsToWriteY(int[][] grid) {
3        int res = Integer.MAX_VALUE;
4        int[] countY = new int[3];
5        int[] countNy = new int[3];
6        int n = grid.length;
7
8        for (int r = 0; r < n; r++) {
9            for (int c =0; c < n; c++) {
10                if (isY(r,c, n)) {
11                    countY[grid[r][c]]++;
12                } else {
13                    countNy[grid[r][c]]++;
14                }
15            }
16        }
17
18        int totalY = countY[0] + countY[1] + countY[2];
19        int totalNy = countNy[0] + countNy[1] + countNy[2];
20
21        for (int i = 0; i < 3; i++) { // y color 这里是3！不是n
22            for (int j = 0; j < 3; j++) { // non y color
23                if (j == i) {
24                    continue;
25                }
26                
27                int ops = (totalY - countY[i]) + (totalNy - countNy[j]);
28                res = Math.min(ops, res);
29
30            }
31
32        }
33        return res;    
34    }
35
36    private boolean isY(int row, int col, int n) {
37        int mid = n/2;
38        if (row == col && row <= mid) {
39            return true;
40        } 
41        
42        if (row + col == n-1 && row <= mid) {
43            return true;
44
45        } 
46        if (row > mid && col == mid) {
47            return true;
48
49        }
50        return false;
51
52    }
53}
54
55
56/***
57
581. 统计y/ non y 各数字出现的次数, for loop
59int[] countY = new int[3];  0/1/2
60int[] countNotY = new int[3];
61
622. 如何判断 y/ non y （r,c）
63mid = n/2 (m,m)
64- r == c r <= mid
65- r+c== n-1 r<= mid
66- c== mid, r > mid
67
683. 把所有颜色统一， y 一种，non y 一种
69totaly = count
70totalnoty
71minres = Integer.MAX_VALUE
72
73
74for 循环遍历
75要求颜色不一样，所以i j 一致时continue
76求修改个数 ：totaly-已经是的 + totalnony - 已经是的
77
78
79 */