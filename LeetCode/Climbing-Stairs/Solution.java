1class Solution {
2    public int climbStairs(int n) {
3        if (n <= 2) {
4            return n;
5        }
6        int first = 1;
7        int second = 2;
8        int third = 0;
9        for (int i = 3; i <= n; i++) {
10            third = first + second;
11            first = second;
12            second = third;
13
14
15        }
16        return third;
17
18
19        
20    }
21}
22/**
23dp[]: 
24
251.
262.
27 */