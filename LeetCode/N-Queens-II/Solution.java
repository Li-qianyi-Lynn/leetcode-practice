1class Solution {
2    private int res = 0;
3    public int totalNQueens(int n) {
4        if (n == 1) {
5            return 1;
6        }
7
8        boolean[] cols = new boolean[n];
9        boolean[] diag1 =new boolean[2 * n];
10        boolean[] diag2 =new boolean[2 * n]; 
11
12        backtracking(0,n,cols, diag1, diag2);
13        return res;
14        
15    }
16
17    private void backtracking(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
18        if (row == n) {
19            res ++;
20            return;
21        }
22
23        for (int i = 0; i < n; i++) {
24            int id1 = row - i + n;
25            int id2 = row + i;
26            if (cols[i] || diag1[id1] || diag2[id2]) {
27                continue;
28
29            }
30            cols[i] = true;
31            diag1[id1] = true;
32            diag2[id2] = true;
33
34            backtracking(row+1,n, cols, diag1, diag2);
35            
36            cols[i] = false;
37            diag1[id1] = false;
38            diag2[id2] = false;
39
40
41
42        }
43
44    }
45}
46
47/**
48每一列每一行每一个对角线（正反）都不能有queue
49每一行放一个queue 检查列对角线是不是有，如果有，pass，如果没有，继续检查，检查完一列回溯
50
51
52 */