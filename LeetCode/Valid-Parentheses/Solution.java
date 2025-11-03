class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Deque<Character> deque = new ArrayDeque<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for (int i = 0; i < s.length(); i++) {
            if ( !map.containsKey(s.charAt(i))) {
                deque.addLast(s.charAt(i));

            } else {
                if(!deque.isEmpty() && deque.peekLast() == map.get(s.charAt(i))) {
                    deque.removeLast();
                } else {
                    return false;
                }

            }

        }
        return deque.isEmpty();

        
    }
}