1class Solution {
2    public int calculate(String s) {
3        Deque<Integer> dq = new ArrayDeque<>();
4        int mark = 1;
5        int res = 0;
6        int n = s.length();
7        for (int i = 0; i < n; i++) {
8            char c = s.charAt(i);
9            if (c == '(') {
10                dq.offerLast(res);
11                dq.offerLast(mark);
12
13                res = 0;
14                mark = 1;
15
16            } else if (c == ')') {
17                int premark = dq.pollLast();
18                int preres = dq.pollLast();
19
20                res = premark * res + preres;
21
22            } else if (c == '+') {
23                mark = 1;
24
25            } else if (c== '-') {
26                mark = -1;
27
28            } else if (c == ' ') {
29                continue;
30
31            } else {
32                int num = 0;
33                while (i < n && Character.isDigit(s.charAt(i))) {
34                    num = num * 10 + s.charAt(i) - '0';
35                    i++;
36                }
37                res += num * mark;
38                i--;
39
40            }
41
42        }
43        return res;
44
45
46        
47    }
48}
49
50/**
51dq
52mark
53
54(: restore res before, start new cal
55): cal the res, restore it to dq
56
57
58 */