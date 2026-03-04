1class Solution {
2    public boolean isValid(String s) {
3        if (s.length() ==1) return false;
4        Map<Character, Character> map = new HashMap<>();
5        map.put(')','(');
6        map.put('}','{');
7        map.put(']','[');
8
9        Deque<Character> deque = new ArrayDeque<>();
10        for (char c : s.toCharArray()) {
11            if (!map.containsKey(c)) {
12                deque.offerLast(c);
13            } else {
14                if (!deque.isEmpty() && deque.peekLast() == map.get(c)) {
15                    deque.removeLast();
16                } else {
17                    return false;
18                }
19            }
20        }
21        return deque.isEmpty();      
22    }
23}