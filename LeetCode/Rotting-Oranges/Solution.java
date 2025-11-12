class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    deque.offerLast(new int[]{i, j});
                }
            }
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 1; i <= size; i++) {
                int[] poll = deque.pollFirst();

                int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0];
                    int y = poll[1] + dir[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols ) {
                        continue;
                    }

                    if (grid[x][y] == 1) {
                        deque.offerLast(new int[]{x,y});
                        grid[x][y] = 2;
                    }

                }

            }

            if (!deque.isEmpty()) {
                res++;
            }
        }
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }
}