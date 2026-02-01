1import java.util.*;
2
3class Solution {
4    public int snakesAndLadders(int[][] board) {
5        int n = board.length;
6        int target = n * n;
7        
8        // 用于记录到达每个方块的最少步数
9        int[] dist = new int[target + 1];
10        Arrays.fill(dist, -1);
11        
12        Queue<Integer> queue = new LinkedList<>();
13        
14        // 起点
15        queue.offer(1);
16        dist[1] = 0;
17        
18        while (!queue.isEmpty()) {
19            int curr = queue.poll();
20            
21            // 如果到达终点，直接返回步数
22            if (curr == target) return dist[curr];
23            
24            // 模拟掷骰子 1-6
25            for (int i = 1; i <= 6; i++) {
26                int next = curr + i;
27                if (next > target) break;
28                
29                // 获取对应的矩阵坐标
30                int[] pos = getCoords(next, n);
31                int r = pos[0];
32                int c = pos[1];
33                
34                // 如果有蛇或梯子，跳到目的地；否则留在原处
35                int destination = (board[r][c] == -1) ? next : board[r][c];
36                
37                // 如果这个点没走过，加入队列
38                if (dist[destination] == -1) {
39                    dist[destination] = dist[curr] + 1;
40                    queue.offer(destination);
41                }
42            }
43        }
44        
45        return -1; // 无法到达
46    }
47
48    // 将方块编号转为矩阵坐标
49    private int[] getCoords(int val, int n) {
50        int r = (val - 1) / n;
51        int c = (val - 1) % n;
52        
53        // 实际上行是从底部开始算的
54        int row = n - 1 - r;
55        
56        // 根据行数决定列是从左往右还是从右往左
57        int col = (r % 2 == 0) ? c : n - 1 - c;
58        
59        return new int[]{row, col};
60    }
61}