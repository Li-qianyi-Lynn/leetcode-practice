1class Solution {
2    public boolean isValid(String s) {
3        Deque<Character> stack = new ArrayDeque<>();
4        Map<Character, Character> map = new HashMap<>();
5        map.put(')','(');
6        map.put(']','[');
7        map.put('}','{');
8        for (char c : s.toCharArray()) {
9            if (map.containsKey(c) && !stack.isEmpty()) {
10                char cur = stack.pollLast();
11                if (cur != map.get(c)) {
12                    return false;
13                }
14            } else {
15                stack.offerLast(c);
16
17            }
18            
19        }
20        return stack.isEmpty();
21        
22    }
23}
24// stack
25/**
26( added to stack
27) check if has (
28
29
30
31 */