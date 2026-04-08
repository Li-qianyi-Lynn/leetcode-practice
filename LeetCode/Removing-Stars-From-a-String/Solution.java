1class Solution {
2    public String removeStars(String s) {
3        Deque<Character> dq = new ArrayDeque<>();
4        for (char c : s.toCharArray()) {
5            if (c == '*') {
6                dq.pollLast();
7            } else {
8                dq.offerLast(c);
9            }
10        }
11        StringBuilder sb = new StringBuilder();
12        while (!dq.isEmpty()) {
13            sb.append(dq.pollFirst());
14
15        }
16        
17        return sb.toString();
18    }
19}