1class Solution {
2    public void wallsAndGates(int[][] rooms) {
3        int rows = rooms.length;
4        if (rows == 0) return;
5        int cols = rooms[0].length;
6        Deque<int[]> q = new LinkedList<>();
7        for (int i = 0; i < rows; i++) {
8            for (int j = 0; j < cols; j++) {
9                if (rooms[i][j] == 0) {
10                    q.add(new int[]{i,j});
11                }
12            }
13        }
14        while (!q.isEmpty()) {
15            int[] point = q.pollFirst();
16            int row = point[0];
17            int col = point[1];
18
19            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
20            for (int[] dir : dirs) {
21                int x = row + dir[0];
22                int y = col + dir[1];
23
24                if (x < 0 || y < 0|| x >= rows || y >= cols || rooms[x][y] != Integer.MAX_VALUE) {
25                    continue;
26                }
27                rooms[x][y] = rooms[row][col] +1;
28                q.add(new int[] { x, y });
29
30
31            }
32
33        }
34
35
36
37
38        
39    }
40}