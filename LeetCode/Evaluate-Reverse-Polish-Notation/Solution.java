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
11            int number2 = deque.pollLast();
12            int number1 = deque.pollLast();
13
14            int result = 0;
15
16            switch (token) {
17                case "+":
18                    result = number1 + number2;
19                    break;
20                case "-":
21                    result = number1 - number2;
22                    break;
23                case "*":
24                    result = number1 * number2;
25                    break;
26                case "/":
27                    result = number1 / number2;
28                    break;
29            }
30
31            deque.offerLast(result);
32        }
33
34        return deque.pollLast();
35    }
36}