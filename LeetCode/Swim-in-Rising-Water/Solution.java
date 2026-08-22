1class Solution {
2    public int swimInWater(int[][] grid) {
3        int n = grid.length;
4        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
5        boolean[][] visited = new boolean[n][n];
6
7        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
8        minHeap.offer(new int[]{grid[0][0],0,0});
9
10        while (!minHeap.isEmpty()) {
11            int[] poll = minHeap.poll();
12            int time = poll[0];
13            int row = poll[1];
14            int col = poll[2];
15            if (row == n -1 && col == n-1) {
16                return time;
17
18            }
19            if (visited[row][col] == true) {
20                continue;
21            }
22
23            visited[row][col] = true;
24
25            for (int[] dir : dirs) {
26                int x = dir[0] + row;
27                int y = dir[1] + col;
28
29                if (x >= 0 && x < n && y >= 0 && y < n && visited[x][y] == false) {
30                    int newTime = Math.max(time, grid[x][y]);
31                    int[] next = new int[]{newTime, x, y};
32                    minHeap.offer(next);
33
34                }
35
36            }
37
38        }
39        return -1;
40    }
41}
42/**
43
44minheap
45
46time needed : Math.max(grid[i][j],time) 
47
48
49 */