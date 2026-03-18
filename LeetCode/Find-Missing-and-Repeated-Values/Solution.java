1class Solution {
2    public int[] findMissingAndRepeatedValues(int[][] grid) {
3        int[] res = new int[2];
4        int n = grid.length;
5        int[] map = new int[n*n+1];
6        
7        for (int i = 0; i <n; i++) {
8            for (int j = 0; j <n; j++) {
9                if (map[grid[i][j]]== 1) {
10                    res[0] = grid[i][j];
11
12                }
13                map[grid[i][j]] = 1;
14
15            }
16
17        }
18        for (int i = 0; i < map.length;i++) {
19            if (map[i] == 0 && i!=0 ) {
20                res[1]=i;
21
22            }
23
24        }
25        return res;
26        
27    }
28}