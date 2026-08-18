1class Solution {
2    public int evalRPN(String[] tokens) {
3        Deque<Integer> deque = new ArrayDeque<>();
4       
5        for (String token : tokens) {
6            if (!"+-*/".contains(token)) {
7                deque.offerLast(Integer.valueOf(token));
8                continue;
9            }
10
11            int fi = deque.pollLast();
12            int se = deque.pollLast();
13            int res = 0;
14
15            if (token.equals("+")) {
16                res = fi + se;
17
18            } else if (token.equals("-")) {
19                res = se - fi;
20
21            } else if (token.equals("*")) {
22                res = se * fi;
23
24            } else {
25                res = se / fi;
26            }
27            deque.offerLast(res);
28        }
29        return deque.pollLast();
30        
31        
32            
33            
34
35           
36
37       
38    }
39}