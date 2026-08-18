1class Solution {
2    public int evalRPN(String[] tokens) {
3        Deque<Integer> dq = new ArrayDeque<>();
4        for (String s: tokens) {
5            if (s.equals("+") ||s.equals("-") || s.equals("*") ||s.equals("/")) {
6                int first = dq.pollLast();
7                int second = dq.pollLast();
8                int curSum = getRes(s, second, first);
9                dq.offerLast(curSum);
10
11            } else {
12                int cur = Integer.valueOf(s); //todo
13                dq.offerLast(cur);
14            }
15        
16        }
17        return dq.pollLast();
18        
19    }
20
21
22    private int getRes(String sign, int second, int first) {
23        int res = 0;
24        if (sign.equals("+")) {
25            res = second + first;
26
27        } else if (sign.equals("-")) {
28            res = second - first;
29
30        } else if (sign.equals("*")) {
31            res = second * first;
32
33        } else if (sign.equals("/")) {
34            res = second / first;
35
36        }
37        return res;
38
39    }
40}
41/**
42stack -> num (cal sum)
43
44
45
46
47+
48stack.pull previous two
49stack.add (sum)
50
51-
52second - first 
53stack
54
55*
56
57/ (order)
58
59
60
61
62 */