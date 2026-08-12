1class Solution {
2    public boolean isValid(String s) {
3        Deque<Character> dq = new ArrayDeque<>();
4        Map<Character, Character> map = new HashMap<>();
5        map.put(')','(');
6        map.put(']','[');
7        map.put('}','{');
8
9        for (char c : s.toCharArray()) {
10            if (map.containsKey(c) && !dq.isEmpty() ) {
11                char poll = dq.pollLast();
12                if (map.get(c) != poll) {
13                    return false;
14                }
15
16            } else {
17                dq.offerLast(c);
18            }
19        }
20
21        return dq.isEmpty();
22
23        
24    }
25}