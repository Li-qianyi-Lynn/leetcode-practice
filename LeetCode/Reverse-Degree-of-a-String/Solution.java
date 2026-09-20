1class Solution {
2    public int reverseDegree(String s) {
3        int res = 0;
4        int idx = 1;
5        for (char c : s.toCharArray()) {  
6            int reversed = 27 - (c - 'a' +1);
7            res += idx * reversed;
8            idx++;
9        }
10        return res;
11    }
12}