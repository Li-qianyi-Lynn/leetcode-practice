1class Solution {
2    private List<List<String>> res = new ArrayList<>();
3    private HashSet<Integer> col = new HashSet<>();
4    private HashSet<Integer> diag = new HashSet<>();
5    private HashSet<Integer> antiDiag = new HashSet<>();
6
7    public List<List<String>> solveNQueens(int n) {
8        char[][] board = new char[n][n];
9        for (int i = 0; i < n; i++) {
10
11            Arrays.fill(board[i],'.');
12        }
13
14        backtracking(0, n,board);
15        return res;
16        
17        
18    }
19
20    private void backtracking(int row, int n,char[][] board) {
21        //base case
22        if (row == n) {
23            List<String> newSol = new ArrayList<>();
24            for (char[] r: board) {
25                newSol.add(new String(r));
26
27            }
28            res.add(newSol);
29            return;
30            
31
32        }
33        //col
34        for (int i = 0; i < n; i++) {
35            int d = row - i;
36            int ad = row +i;
37
38            if (col.contains(i) || diag.contains(d) || antiDiag.contains(ad)) {
39                continue;
40            }
41
42            col.add(i);
43            diag.add(d);
44            antiDiag.add(ad);
45            board[row][i] = 'Q';
46
47            backtracking(row + 1, n, board);
48            col.remove(i);
49            diag.remove(d);
50            antiDiag.remove(ad);
51            board[row][i] = '.';
52        }
53
54
55    }
56}