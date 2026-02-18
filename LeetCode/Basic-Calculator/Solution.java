1/**
2(23+5) + 6
3
4 */
5class Solution {
6    public int calculate(String s) {
7        int res = 0;
8        Deque<Integer> dq = new ArrayDeque<>();
9        int sign = 1;
10        int len = s.length();
11
12        for (int i = 0; i < len; i++) {
13            char c = s.charAt(i);
14
15            if (c == '(') {
16                dq.offerLast(res);
17                dq.offerLast(sign);
18
19                res = 0;
20                sign = 1;
21            } else if (c == ')') {
22                int preSign = dq.pollLast();
23                int preSum = dq.pollLast();
24                
25                res = preSign * res + preSum;
26            } else if (c == '+') {
27                sign = 1;
28
29            } else if (c == '-') {
30                sign = -1;
31
32            } else if (Character.isDigit(c)) {
33                int num = 0;
34                while (i < len && Character.isDigit(s.charAt(i))) {
35                    num = num * 10 + s.charAt(i)-'0';
36                    i++;
37                }
38                res += num * sign;
39                i--;
40
41            } else {
42                continue;
43            }
44
45        }
46        return res;
47        
48    }
49}
50
51/**
52res 
53sign +/- 1/-1
54deque 
55
56(： 
57把之前算的res 存进去
58把sign 存进去
59重置res and sign
60
61）：
62获得res*sign poll
63获得res += 上一个存进去的res
64
65+/-：
66update sign
67
68num：
69res = sign* num
70multi digit:
71int num = 0;
72num * 10 + c-'0'
73
74
75 */