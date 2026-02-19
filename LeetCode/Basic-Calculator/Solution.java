1class Solution {
2    public int calculate(String s) {
3        Deque<Integer> dq = new ArrayDeque<>();
4        int res = 0; 
5        int n = s.length();
6        int mark = 1;
7
8        for (int i = 0; i < n; i++) {
9            char c = s.charAt(i);
10
11            if (c == '(') {
12                dq.offerLast(res);
13                dq.offerLast(mark);
14
15                res = 0;
16                mark = 1;
17            } else if (c ==')') {
18                int preMark = dq.pollLast();
19                int preSum = dq.pollLast();
20
21                res = preMark * res + preSum;
22            } else if (c == '+') {
23                mark = 1;
24
25            } else if (c == '-') {
26                mark = -1;
27
28            } else if (Character.isDigit(c)) {
29                int num = 0;
30                while (i < n && Character.isDigit(s.charAt(i))) {
31                    num = num * 10 + s.charAt(i) - '0';
32                    i++;
33                }
34                res += num * mark;
35                i--;
36                
37            } else {
38                continue;
39            }
40        }
41        return res;
42        
43    }
44}
45/**
46input: String 去做一下识别, 遇到 empty skip
47output: int 
48
49iterate s, get the char
50
511. 知道 +/-
522. 需要先放下目前在算的值，先计算括号里的sum
53
54stack:
55(: 1. 把之前算的sum 保存下来，还要把mark 保存下来 (+/-)
562. 开始这个括号里的计算
57
58cur: 0 
59
60）：
611.需要拿到之前存进去的premark, premark * cur -》现在这一层（）的结果
622. 拿到之前存的sum
632. cur = 这一层的结果和之前存的sum 加起来 
64
65+:
66mark = 1;
67
68
69-:
70mark = -1;
71
72digit:
730-9 可能会重复出现: 11+1 111+1
74
75num = 0
76c= charAt(i)
77while (i < length of string && charAt(i) is digit) {
78    num += num * 10 + digit of charAt(i)
79    i++
80}
81i--
82
83
84else:
85continue
86
87
88
89
90
91
92 */