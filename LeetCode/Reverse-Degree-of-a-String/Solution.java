1class Solution {
2    public int reverseDegree(String s) {
3        int res = 0;
4      
5        for (int i = 0; i < s.length(); i++) {  
6            int idx = i+1;
7            int reversed = 27 - (s.charAt(i) - 'a' +1);
8            res += idx * reversed;
9        }
10        return res;
11    }
12}