1class Solution {
2    public int findNthDigit(int n) {
3        if (n <= 9) {
4            return n;
5
6        }
7        int len = 1;
8        long count = 9;
9        long start = 1;
10
11        while (n > count) {
12            n -= count;
13            len++;
14            start *= 10;
15            count = len * start * 9;
16
17        }
18
19        long num = start + (n - 1)/ len;
20        int idx = (n-1) % len;
21
22        return Long.toString(num).charAt(idx) - '0';
23        
24    }
25}
26/**
27
28
291-9 9 n
3010-99 90* 2 = 180 digits
31100-999 900* 3 = 2700 digits
32
33n > 9
34n - 9 去比180
35
36
37num ?
38第几位
39
40
41 */