1class Solution {
2    public int maxPoints(int[][] points) {
3        if (points.length <= 2) {
4            return points.length;
5
6        }
7        int n = points.length;
8        int res = 0;
9        for (int i = 0; i < n; i++) {
10            Map<String, Integer> map = new HashMap<>();
11            for (int j = i+1; j < n; j++) {
12                int dy = points[j][1]-points[i][1];
13                int dx = points[j][0]-points[i][0];
14
15                int common = helper(dy, dx);
16                dy = dy / common;
17                dx = dx / common;
18                String k = dy + "/" + dx;
19                map.put(k, map.getOrDefault(k,0)+1);
20                res = Math.max(res, map.get(k));
21
22            }
23        }
24        return res+1;
25        
26    }
27
28    private int helper(int a,int b) {
29        while (b != 0) {
30            int temp = a % b;
31            a = b;
32            b = temp;
33
34        }
35        return a;
36    }
37}