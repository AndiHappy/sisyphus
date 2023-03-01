package l;

import java.util.Stack;

public class LeetCode150 {

    public static void main(String[] args) {
        System.out.println("keep happy");
        String[] result = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(result));

        result = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(result));

        result = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(result));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            String tokeni = tokens[i];
            if (tokeni.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                Integer fist = stack.pop();
                Integer second = stack.pop();
                stack.push(second / fist);
            } else {
                stack.push(Integer.parseInt(tokeni));
            }
        }
        return stack.pop();
    }
}
