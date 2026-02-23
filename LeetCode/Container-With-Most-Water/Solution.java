1class Solution {
2    public int maxArea(int[] height) {
3        int r = height.length-1;
4        int l = 0;
5        int res = 0;
6
7        while (l < r) {
8            int cur =  (r-l) * Math.min(height[r],height[l]);
9            res = Math.max(cur,res);
10            if (height[r] < height[l]) {
11                r--;
12
13            } else {
14                l++;
15            }
16        }
17        return res;
18
19        
20    }
21}
22/**
23r-l
24max(height[r],height[l])
25 */