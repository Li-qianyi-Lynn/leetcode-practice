1/**
2use bfs(deque)
3while (deque is not empty)
41. iterate the whole map, when gird[m][n] == 1, add it to the deque, fruit++, 
5bfs:
62. popout grid[m][n] = 2, marked as processed, fruit--, time ++
73. int[][] directions, iterate four directions, if grid[m][n] == 1, also add it to the deque as the next level
8
94.  check if fruit is 0 or not, if ==0, return time; otherwise return -1
10 */
11class Solution {
12    public int orangesRotting(int[][] grid) {
13        // if (grid.length == 0 || grid[0].lenght == 0) {
14        //     return -1
15        // }
16        int time = 0;
17        int freshFruit = 0;
18        Deque<int[]> deque = new ArrayDeque<>();
19        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
20
21        int rows = grid.length;
22        int cols = grid[0].length;
23        for (int i = 0; i < rows; i++ ) {
24            for (int j = 0; j < cols; j++) {
25                if (grid[i][j] == 1) {
26                    freshFruit ++;
27                } else if (grid[i][j] == 2) { // find rotted oranges as the first level
28                    deque.offerLast(new int[]{i,j});
29
30                }
31            }
32        }
33
34        // rotted oranges affect other fresh oranges, time ++ if there are other oranges will be rotted
35        while (!deque.isEmpty()) {
36            int size = deque.size();
37            for (int i = 0; i < size; i++) {
38                int[] pos = deque.pollFirst();
39                int row = pos[0];
40                int col = pos[1];
41
42                for (int[] dir : dirs) {
43                int x = dir[0] + row;
44                int y = dir[1] + col;
45                    if ( x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
46                    grid[x][y] = 2;
47                    freshFruit --;
48                    deque.offerLast(new int[]{x,y});
49                    }
50                }
51            }
52            if (!deque.isEmpty()) {
53                time++;
54            }
55        }
56
57        return freshFruit == 0 ? time : -1;
58    }
59    
60}
61