package accumulate.stack;

import java.util.Stack;

public class L32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(")); //0
        System.out.println(longestValidParentheses("()")); //2
        System.out.println(longestValidParentheses("()(()")); //2
        System.out.println(longestValidParentheses("()()"));  //4
        System.out.println(longestValidParentheses(")()())"));//4
        System.out.println(longestValidParentheses("()(()")); //2
        System.out.println(longestValidParentheses(")()())"));//4
    }


    /**
     * ()()),
     * ()((),
     * (()((),
     * ((()
     * */
    public static int longestValidParentheses(String s){
        Stack<Integer> st = new Stack<Integer>();
        Integer left = null;
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            Character si = s.charAt(i);
            if('(' == si) {
                st.push(i);
            }else{
                // 如果这个时候的stack为null，说明)为一段开局的字符，或者初始化的字符
                if(st.isEmpty()){
                    left=i;
                }else{
                    st.pop();// 说明匹配到一个字符，没有pop前，栈顶元素是(,对应的index是stack.peek, 当前的index=i
                    if(st.isEmpty()) {
                        //如果此时栈内为null，说明已经匹配到了一个可以计算的【完美一段括号字符串】，例如(),或者(())
                        if(left == null){ //如果left为null，说明一直是【完美一段括号字符串】
                            max = i+1;
                        }else{
                            max = Math.max(max,i-left);
                        }
                    }else{
                        //如果这个时候，栈内还有元素，就是栈内就是对应(((的index，仍然需要计算一个短的【完美一段括号字符串】
                        max = Math.max(max,i-st.peek());
                    }
                }
            }
        }
        return max;
    }
}
