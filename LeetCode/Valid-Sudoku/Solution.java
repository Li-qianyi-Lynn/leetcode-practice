class Solution {
    public boolean isValidSudoku(char[][] board) {
        // if each row/cols/square has digits 1-9 with repetition
        // the hardest point is how to locate square cols and rows
        // square
        for (int sqr = 0; sqr < 9; sqr++) {
            Set <Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int rows = (sqr / 3) * 3 +i;
                    int cols = (sqr % 3) * 3 +j;
                    if (board[rows][cols] == '.' ) { continue;}
                    if (seen.contains(board[rows][cols])) { return false;}
                    seen.add(board[rows][cols]);

                }

            }
        }

        // rows
        for (int row = 0; row < 9; row++) {
            Set <Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') { continue;}
                if (seen.contains(board[row][i])) { return false;}
                    seen.add(board[row][i]);
            }
        }

        for (int col = 0; col < 9; col++) {
            Set <Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') { continue;}
                if (seen.contains(board[i][col])) { return false;}
                    seen.add(board[i][col]);
            }


        }
        return true;


        
        
    }
}