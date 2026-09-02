1class Solution {
2    public int findNthDigit(int n) {
3        int len = 1;
4        long count = 9;
5        long start = 1;
6
7        while (n > count) {
8            n -= count;
9            len++;
10            start *= 10;
11            count = len * start * 9;
12
13        }
14
15        long num = start + (n-1)/len;
16        int index = (n - 1) % len;
17        return Long.toString(num).charAt(index) - '0';
18    }
19}
20/**
21 n.        count
220-9         9
2310-99       180
24100-999      270
25
2610 1
2711 0
2812 1
2913 1
3014 1
3115 2
32...
3330.2
342  2
35
36len
37count: 
38start
39
40
41
42 */