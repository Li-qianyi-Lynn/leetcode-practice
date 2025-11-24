class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                deque.offerLast(Integer.valueOf(token));
                continue;
            }

            int number2 = deque.pollLast();
            int number1 = deque.pollLast();

            int result = 0;

            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }

            deque.offerLast(result);
        }

        return deque.pollLast();
    }
}