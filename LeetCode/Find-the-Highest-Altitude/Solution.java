1class Solution {
2    public int largestAltitude(int[] gain) {
3        int prefix = 0;
4        int res = 0;
5        for (int g : gain) {
6            prefix += g;
7            res = Math.max(res,prefix);
8        }
9        return res;
10
11        
12    }
13}
14
15/**
16input: int[] gain
17putput: int   highest altitude of a point
18
19[-5,1,5,0,-7]
20-: go down
21+: go up
22 
23 0 - 5 + 1 + 5 - 7
24
25 prefix 
26 int res: max prefix
27 */