1class Solution {
2    private int size;
3    private List<List<String>> solutions = new ArrayList<List<String>>();
4
5    public List<List<String>> solveNQueens(int n) {
6        size = n;
7        char emptyBoard[][] = new char[size][size];
8        for (int i = 0; i < n; i++) {
9            for (int j = 0; j < n; j++) {
10                emptyBoard[i][j] = '.';
11            }
12        }
13
14        backtrack(
15            0,
16            new HashSet<>(),
17            new HashSet<>(),
18            new HashSet<>(),
19            emptyBoard
20        );
21        return solutions;
22    }
23
24    // Making use of a helper function to get the
25    // solutions in the correct output format
26    private List<String> createBoard(char[][] state) {
27        List<String> board = new ArrayList<String>();
28        for (int row = 0; row < size; row++) {
29            String current_row = new String(state[row]);
30            board.add(current_row);
31        }
32
33        return board;
34    }
35
36    private void backtrack(
37        int row,
38        Set<Integer> diagonals,
39        Set<Integer> antiDiagonals,
40        Set<Integer> cols,
41        char[][] state
42    ) {
43        // Base case - N queens have been placed
44        if (row == size) {
45            solutions.add(createBoard(state));
46            return;
47        }
48
49        for (int col = 0; col < size; col++) {
50            int currDiagonal = row - col;
51            int currAntiDiagonal = row + col;
52            // If the queen is not placeable
53            if (
54                cols.contains(col) ||
55                diagonals.contains(currDiagonal) ||
56                antiDiagonals.contains(currAntiDiagonal)
57            ) {
58                continue;
59            }
60
61            // "Add" the queen to the board
62            cols.add(col);
63            diagonals.add(currDiagonal);
64            antiDiagonals.add(currAntiDiagonal);
65            state[row][col] = 'Q';
66
67            // Move on to the next row with the updated board state
68            backtrack(row + 1, diagonals, antiDiagonals, cols, state);
69
70            // "Remove" the queen from the board since we have already
71            // explored all valid paths using the above function call
72            cols.remove(col);
73            diagonals.remove(currDiagonal);
74            antiDiagonals.remove(currAntiDiagonal);
75            state[row][col] = '.';
76        }
77    }
78}