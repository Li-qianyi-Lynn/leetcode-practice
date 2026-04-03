1class Solution {
2    public int climbStairs(int n) {
3        if ( n <= 2) {
4            return n;
5
6        }
7        int first = 1;
8        int second = 2;
9        for (int i = 3; i <= n; i++) {
10            int third = first + second;
11            first = second;
12            second = third;
13        }
14        return second;
15
16        
17    }
18}