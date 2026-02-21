1class Solution {
2    public int calPoints(String[] operations) {
3        Deque<Integer> dq = new ArrayDeque<>(); // stack
4        for (String s : operations) {
5            if (s.equals("C")) {
6                dq.pollLast();
7            } else if (s.equals("D")) {
8                int prev = dq.pollLast();
9                dq.offerLast(prev);
10                dq.offerLast(prev * 2);
11
12            } else if (s.equals("+")) {
13                int first = dq.pollLast();
14                int second = dq.pollLast();
15                dq.offerLast(second);
16                dq.offerLast(first);
17                dq.offerLast(first+ second);
18
19            } else {
20                int num = Integer.parseInt(s);
21                dq.offerLast(num);
22            }
23        }
24
25        int res = 0;
26        while (!dq.isEmpty()) {
27            res += dq.pollLast();
28
29        }
30        return res;
31        
32    }
33}