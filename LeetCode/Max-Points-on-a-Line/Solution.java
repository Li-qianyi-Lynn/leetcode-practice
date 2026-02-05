1class Solution {
2    public int maxPoints(int[][] points) {
3        if (points.length <= 2) {
4            return points.length;
5
6        }
7        int n = points.length;
8        int maxP = 0;
9
10        for (int i = 0; i < n; i++) {
11            Map<String, Integer> map = new HashMap<>();
12
13            for (int j = i+1; j < n; j++) {
14                int dy = points[j][1] - points[i][1];
15                int dx = points[j][0] - points[i][0];
16                int common = gcd(dx, dy);
17                dx /= common;
18                dy /= common;
19                
20                String key = dy + "/" + dx;
21                map.put(key, map.getOrDefault(key, 0) + 1);
22                maxP = Math.max(maxP, map.get(key));
23            }   
24        }
25        return maxP + 1;
26        
27    }
28
29    private int gcd(int a, int b) {
30        while (b!= 0) {
31            int temp = a % b;
32            a = b;
33            b = temp;
34
35        }
36        return a;
37       
38    }
39}
40/**
41y = kx
42k = y/x
43
44
45 */