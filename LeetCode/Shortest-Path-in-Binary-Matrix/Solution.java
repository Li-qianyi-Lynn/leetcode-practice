1class Solution {
2
3    public int shortestPathBinaryMatrix(int[][] grid) {
4        int n = grid.length;
5
6        if (n <= 0 || grid[0][0] != 0 || grid[n-1][n-1] != 0) {
7            return -1;
8        }
9        Deque<int[]> dq = new ArrayDeque<>();
10        int[][] directions = {{1,0},{0,1}, {-1, 0},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};
11        grid[0][0] = 1;
12        int len = 1;
13        dq.offerLast(new int[]{0,0});
14
15        while (!dq.isEmpty()) {
16            int size = dq.size();
17            for (int i = 0;i < size; i++) {
18                int[] cur = dq.pollFirst();
19                int row = cur[0];
20                int col = cur[1];
21
22                // to end
23                if (row == n-1 && col == n-1) {
24                    return len;
25
26                }
27
28                for (int[] dir : directions) {
29                    int x = row + dir[0];
30                    int y = col + dir[1];
31
32                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
33                        grid[x][y] = 1;
34                        dq.offerLast(new int[]{x, y});
35
36                    }
37                }
38            }
39            len++;
40        }
41        return -1;        
42    }
43}