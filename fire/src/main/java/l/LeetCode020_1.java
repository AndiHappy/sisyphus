package l;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode020_1 {

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
//
// Example 1:
//
//
//Input: s = "()"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: s = "(]"
//Output: false
//
//
// Example 4:
//
//
//Input: s = "([)]"
//Output: false
//
//
// Example 5:
//
//
//Input: s = "{[]}"
//Output: true
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
//

    /**
     * 如果() []  {} 具有优先级，()的优先级为3，[] 优先级为2，{} 优先级为1
     * ([]),[{}] 为错误的示例。
     *
     * */
    static HashMap<Character,Integer> level = new HashMap<>();
    static {
        level.put('(',3);
        level.put(')',3);
        level.put('[',2);
        level.put(']',2);
        level.put('{',1);
        level.put('}',1);
    }
    public static boolean isValid_Level(String s) {
        if(s == null || s.length() <1 ) return true;
        Stack<Character> stack = new Stack<>();
        char[] schars = s.toCharArray();
        int level =0;
        for (int i = 0; i < schars.length; i++) {
            char c = schars[i];
            if(c == '(' || c == '[' || c == '{'){
                if(LeetCode020_1.level.get(c) >= level) {
                    stack.push(c);
                    level = LeetCode020_1.level.get(c);
                }else {
                    return false;
                }
            }else if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    level = iniLeve(stack);
                }else{
                    return false;
                }
            }else if(c == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                    level = iniLeve(stack);
                }else{
                    return false;
                }
            }else if(c == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                    level = iniLeve(stack);
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static int iniLeve(Stack<Character> stack) {
        if(!stack.isEmpty()){
            char c = stack.peek();
            if(c == '(' || c == '[' || c == '{'){
                return  level.get(c);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
        System.out.println(isValid_Level("("));
        System.out.println(isValid_Level(")"));
        System.out.println(isValid_Level("()["));
        System.out.println(isValid_Level("()[]{}"));
        System.out.println(isValid_Level("([])"));
        System.out.println(isValid_Level("([{}]"));
        System.out.println(isValid_Level("()[]{[()]}"));
        System.out.println(isValid_Level("{[([])]}"));
    }

    class Solution {
        public boolean isValid(String s) {
            if(s==null || s.length() == 0) return true;
            Stack<Character> stack = new Stack<Character>();

            for(int i =0 ; i < s.length() ; i++){
                char si = s.charAt(i);
                if(si == '(' || si == '{' || si == '['){
                    stack.push(si);
                }else if( si == ')'){
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }else{
                        return false;
                    }
                } else if( si == ']'){
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if (si == '}'){
                    if(!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

}
