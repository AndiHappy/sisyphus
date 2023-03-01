package l;

import java.util.Stack;

public class LeetCode032 {

    /**
     Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.



     Example 1:

     Input: s = "(()"
     Output: 2
     Explanation: The longest valid parentheses substring is "()".
     Example 2:

     Input: s = ")()())"
     Output: 4
     Explanation: The longest valid parentheses substring is "()()".
     Example 3:

     Input: s = ""
     Output: 0


     Constraints:

     0 <= s.length <= 3 * 104
     s[i] is '(', or ')'.

     * **/

    public static boolean validate(String s){
        if(null == s || s.length() <= 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(')' == s.charAt(i)){
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.peek();
                }else if('(' == s.charAt(i)){
                    stack.push(')');
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (validate(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;

    }

  
    public static int longestValidParentheses_dp(String s) {
        int[] dp = new int[s.length()];
        return  -1;
    }

    public static int longestValidParentheses_s(String s){
        int maxans =0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses_stack_error(String s) {
        int result=0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                //此时，s.charAt(i) == ')'
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    int v = stack.pop();
                    result = Math.max(result,i-v+1);
                }
            }
        }
        return result;

        /*
        int maxans =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
        */

    }


    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        System.out.println(longestValidParentheses_s(")()())))()"));
//        System.out.println(LeetCode032.Solution.longestValidParentheses("(()"));
//        System.out.println(LeetCode032.Solution.longestValidParentheses(")()())"));
    }




    static class Solution_error {
        /***
         最长有效的括号，第一个念头，就是从i到j为有效的括号，长度就是j-i+1
         如果 dp[i][j] 是有序的括号，
         那么 dp[i][j+1] 也是有效的括号，

         也就是 dp[i][j] =  dp[i-1][j+1] && s[j+1] = ')' s[i-1] = '('    ( ,,,,,,, )
                           dp[i-2][j-2] && s[j+1] = ')' s[i-1] = '('    ( ) ,,,,,,, ( )
         所需要的结果是：max(j-i+1)

         */
        public static int longestValidParentheses_error(String s) {
            if(s == null || s.length() <=1) return 0;
            int result =0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            dp[0][0]=false;
            dp[s.length()-1][s.length()-1] = false;
            for(int j=s.length()-1 ; j>=0;j--){
                for(int i = j; i>=0;i--){
                    if((j-i==1) && (s.charAt(j)==')') && (s.charAt(i) =='(')){
                        dp[i][j] = true;
                        result = Math.max(j-i+1,result);
                    }else if( i >0 && j>0 && dp[i-1][j-1] && (s.charAt(j)==')') && (s.charAt(i) =='(')){
                        dp[i][j] = true;
                        result = Math.max(j-i+1,result);
                    } else if ( i >=2 && j >=2
                                && (  (dp[i-2][j-2])  ||  ((i-2) == (j-2)) )
                                &&
                            (s.charAt(j)==')' && s.charAt(j-1)=='(') && (s.charAt(i) =='(' && s.charAt(i-1) ==')')
                    )
                        dp[i][j] = true;
                    result = Math.max(j-i+1,result);
                }
            }
            return result;

        }
    }

    class Solution {
        /***
         如果使用动态规划，那么首先要确定子问题：
         dp[i] 为 0 到 i 有效字符的最大长度
         那么
         dp[i]的确定，只需要在 s[i] =')' 的时候，
         如果 s[i-1] = '('  dp[i]=dp[i-1]+ 2
         如果 s[i-1] = ')'   就是 ( ,,,dp[i-1],,,)) ,如果 i-dp[i-1]-1 如果是( , 则
         dp[i]= dp[i-1]+ dp[i-dp[i-1]-2]+2
         **/
        public int longestValidParentheses(String s) {
            int result = 0;
            int[] dp = new int[s.length()];
            for(int i= 1 ;i <s.length();i++){
                if(s.charAt(i) == ')'){
                    if(s.charAt(i-1) == '('){
                        dp[i] = (i>=2?dp[i-2]:0)+2;
                    }else if( i- dp[i-1] >0 && s.charAt(i-dp[i-1]-1) == '('){
                        dp[i] = dp[i-1]+ ((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0 )+ 2;
                    }
                }
                result = Math.max(result,dp[i]);
            }
            return result;
        }
    }
}
