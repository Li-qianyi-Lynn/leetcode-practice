1class Solution {
2    public int largestAltitude(int[] gain) {
3        int prefix =0;
4        int res = 0;
5        for (int g : gain) {
6            prefix += g;
7            res = Math.max(res, prefix);
8        }
9        return res;
10        
11    }
12}