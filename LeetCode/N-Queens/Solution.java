class Solution {
    private boolean[] visitedCols;
    boolean[] visitedDiag, visitedAntiDiag;
    private List<List<String>> solutionBoards;
    private int[] queenPositions;
    
    public List<List<String>> solveNQueens(int n) {
        visitedCols = new boolean[n];
        visitedDiag = new boolean[n << 1];
        visitedAntiDiag = new boolean[n << 1];
        
        queenPositions = new int[n];
        solutionBoards = new ArrayList<>();
        
        backtrack(n, 0);
        
        return solutionBoards;
    }
    
    private void backtrack(int n, int row){
        if(row == n){
            fillSolutionBoard(n);
        }
        
        for(int col=0; col<n; col++){
            if(!visitedCols[col]
               && !isDiagonalsVisited(row, col, n)){
                queenPositions[row] = col;
                if(row == n-1){
                    fillSolutionBoard(n);
                    continue;
                }
                
                visitedCols[col] = true;
                markDiagonals(row, col, true, n);
                
                backtrack(n, row+1);
                
                queenPositions[row] = -1;
                visitedCols[col] = false;
                markDiagonals(row, col, false, n);
            }
        }
    }
    
    private boolean isDiagonalsVisited(int row, int col, int n){
        int diag = row - col + (n-1);
        int antiDiag = row + col;
        return visitedDiag[diag] || visitedAntiDiag[antiDiag];
    }
    
    private void markDiagonals(int row, int col, boolean isVisit, int n){
        int diag = row - col + (n-1);
        int antiDiag = row + col;
        visitedDiag[diag] = isVisit;
        visitedAntiDiag[antiDiag] = isVisit;
    }
    
    private void fillSolutionBoard(int n){
        List<String> solBoard = new ArrayList<>();
        StringBuilder row = new StringBuilder();
        for(int i=0; i<n; i++)
            row.append('.');
        for(int q=0; q<n; q++){
            row.setCharAt(queenPositions[q], 'Q');
            solBoard.add(row.toString());
            row.setCharAt(queenPositions[q], '.');
        }
        
        solutionBoards.add(solBoard);
    }
}