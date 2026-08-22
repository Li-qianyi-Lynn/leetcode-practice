1class Solution {
2    public int swimInWater(int[][] grid) {
3        int n = grid.length;
4
5        // {time, row, col}
6        PriorityQueue<int[]> pq = new PriorityQueue<>(
7            (a, b) -> a[0] - b[0]
8        );
9
10        boolean[][] visited = new boolean[n][n];
11        pq.offer(new int[]{grid[0][0], 0, 0});
12        /**
13        pq:[[0,0,0]]
14        
15         */
16        int[][] dirs = {
17            {1, 0},
18            {-1, 0},
19            {0, 1},
20            {0, -1}
21        };
22
23        while (!pq.isEmpty()) {
24            int[] cur = pq.poll(); // [0,0,0]
25
26            int time = cur[0]; // 0
27            int row = cur[1]; //0
28            int col = cur[2]; //0
29
30            if (visited[row][col]) {
31                continue;
32            }
33
34            visited[row][col] = true;
35
36            // 第一次到达终点，一定是最小时间
37            if (row == n - 1 && col == n - 1) { //
38                return time;
39            }
40
41            for (int[] dir : dirs) {
42                int newRow = row + dir[0];
43                int newCol = col + dir[1];
44
45                if (newRow < 0 || newRow >= n ||
46                    newCol < 0 || newCol >= n ||
47                    visited[newRow][newCol]) {
48                    continue;
49                }
50
51                int newTime = Math.max(time, grid[newRow][newCol]);
52
53                pq.offer(new int[]{
54                    newTime,
55                    newRow,
56                    newCol
57                });
58            }
59        }
60
61        return -1;
62    }
63}