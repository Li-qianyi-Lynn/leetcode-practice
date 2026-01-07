1class Solution {
2    public int maxArea(int[] height) {
3        int n = height.length-1;
4        int r = n;
5        int l = 0;
6        int res = 0;
7        while (l < r) {
8            int area = Math.min(height[l], height[r]) * (r-l);
9            res = Math.max(area, res);
10            if (height[l] < height[r]) {
11                l++;
12
13            } else {
14                r--;
15            }
16
17        }
18        return res;
19        
20    }
21}
22
23/**
24two pointer 维护 height
25area = Math.min(height[l], height[r]) * (r-l);
26维护lr
27math.max(area,curarea)
28 */
29