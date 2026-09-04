1class Solution {
2    private int count = 0;
3    public int totalNQueens(int n) {
4        HashSet<Integer> col = new HashSet<>();
5
6        HashSet<Integer> diag = new HashSet<>();
7        HashSet<Integer> antiDiag = new HashSet<>();
8
9
10        backtracking(col, diag, antiDiag, n, 0);
11
12        
13        return count;
14
15
16        
17    }
18
19    private void backtracking(HashSet<Integer> col,HashSet<Integer> diag,HashSet<Integer> antiDiag, int n, int row) {
20        //base case
21        if (row == n) {
22            count++;
23            return;
24
25        }
26
27
28        for (int i = 0; i < n; i++) {
29            int diagIdx = row + i;
30            int antiIdx = row - i;
31            if (col.contains(i) ||diag.contains(diagIdx) || antiDiag.contains(antiIdx) ) {
32            continue;
33
34            }
35            col.add(i);
36            diag.add(diagIdx);
37            antiDiag.add(antiIdx);
38            backtracking(col, diag, antiDiag, n, row+1);
39            col.remove(i);
40            diag.remove(diagIdx);
41            antiDiag.remove(antiIdx);
42
43
44
45        }
46
47
48    }
49}
50/**
51int count 
52hashset col diagonal anti-diagonal
53
54void backtracking: to update count
55
56
57
58 */