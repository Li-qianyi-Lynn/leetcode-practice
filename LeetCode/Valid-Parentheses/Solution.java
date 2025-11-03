class Solution {
    public boolean isValid(String s) {
        if (s.length() ==1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                deque.offerLast(c);
            } else {
                if (!deque.isEmpty() && deque.peekLast() == map.get(c)) {
                    deque.removeLast();
                } else {
                    return false;
                }
            }
        }
        return deque.isEmpty();      
    }
}