package accumulate.stack;

import java.util.Stack;

public class L20 {
    /**
     * s: 1 <= s.length <= 104
     *    consists of parentheses only '()[]{}'.
     * ()[]{}
     * */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            if ('(' == tmp || '[' == tmp || '[' == tmp) {
                stack.push(tmp);
            } else if (')' == tmp) {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (']' == tmp) {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if ('}' == tmp) {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
