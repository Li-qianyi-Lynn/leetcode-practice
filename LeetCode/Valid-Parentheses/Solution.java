1class Solution {
2    public boolean isValid(String s) {
3        Deque<Character> stack = new ArrayDeque<>();
4        for (char c : s.toCharArray()) {
5            if (c ==')' && !stack.isEmpty()) {
6                char poll = stack.pollLast();
7                if (poll !='(') {
8                    return false;
9                }
10            } else if (c =='}' && !stack.isEmpty()){
11                char poll = stack.pollLast();
12                if (poll != '{') {
13                    return false;
14
15                }
16            } else if (c == ']' && !stack.isEmpty()) {
17                char poll = stack.pollLast();
18                if (poll != '[') {
19                    return false;
20                }    
21            } else {
22                stack.offerLast(c);
23
24            }
25        }
26        return stack.isEmpty();
27        
28    }
29}
30// stack
31/**
32( added to stack
33) check if has (
34
35
36
37 */