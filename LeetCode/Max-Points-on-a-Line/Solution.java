1class Solution {
2    public int maxPoints(int[][] points) {
3        //edge case
4        if (points.length <= 2) {
5            return points.length;
6
7        }
8
9        int res = 0; 
10        int len = points.length;
11        for (int i = 0; i < len; i++) {
12            Map<String, Integer> map = new HashMap<>();
13            for (int j = i+1; j < len; j++) {
14                int dy = points[j][1] - points[i][1];
15                int dx = points[j][0] - points[i][0];
16                int common = helper(dy,dx); // todo
17
18                dy = dy / common;
19                dx = dx / common;
20                String k = dy + "/" + dx;
21                map.put(k, map.getOrDefault(k,0)+1);
22                res = Math.max(res, map.get(k));
23            }
24
25        }
26        return res+1;
27        
28    }
29
30    private int helper(int a, int b) {
31        while (b != 0) {
32            int temp = a % b;
33            a = b;
34            b = temp;
35        }
36
37        return a;
38    }
39
40/**
41input: int[][] points
42output: int maxNum  points that lie on the same straight line
43
44k = (y2-y1)/(x2-x1) 这些点就在一条直线上
45以某一个点为基准点，k 相似的越多，就是说明有很多个点是在同一条直线上，k -> count
46Map<String, Integer>
47
481. iterate points, 我去拿到基准点
492. second for loop to calculate k = (y2-y1)/(x2-x1) 
503. map put k -> count helper funtion: 最大公约数 -》 最简化的分数（key）
514. 更新map k count， 取最大值
52
5318 12
5418 % 12 = 6
55
5612 % 6 = 0
57while 
58
59return max +1； （res）
60
611,1 x1 = 1 y1 = 1
621,4 x2 = 1 y2 = 4 
63k 不存在
64
65
662,3  x3 = 2 y3 = 3
673,2 x4 = 3 y4 = 2
68k3 = -1/1 =-1
69k = -2/2 = -1
70
71k = 2/1 
72
73
74
75 */}