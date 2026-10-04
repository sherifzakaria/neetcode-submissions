class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 + num1);
                    break;
                }
                case "-": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                }
                case "*": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 * num1);
                    break;
                }
                case "/": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
