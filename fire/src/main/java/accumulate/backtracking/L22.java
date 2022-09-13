package accumulate.backtracking;

import java.util.*;

public class L22 {
    //Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
// Example 1:
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
//Output: ["()"]
//
//
// Constraints:
//
//
// 1 <= n <= 8
//
// Related Topics String Dynamic Programming Backtracking
// 👍 11567 👎 451


    public static void main(String[] args) {
        //"((()))","(()())","(())()","()(())","()()()"
        // 学会控制生成这种，回溯控制
        System.out.println(Arrays.toString(generate(3,0,0,"",new ArrayList<String>()).toArray()));
//        System.out.println(Arrays.toString(generateParenthesis(3).toArray()));
    }

    /**
     * 怎么理解这个过程？
     * 递归是如何递归的？
     * 就像这道题目中的，递归在脑子里面模拟不出来，其实递归就应该是一棵树，根节点就是【0，0，‘’】
     *          【0，0，‘’】
     *      【1，0，‘(’】
     *     【2，0，‘((’】
     *    【3，0，‘(((’】
     *    【3，1,2,3，‘((()))’】
     *
     * */
    private static List<String> generate(int n, int left, int right,String r, List<String> result) {
        if((left == right) && left == n){
            result.add(r);
            return result;
        }
        if(left < n){
            generate(n,left+1,right,r+"(",result);
        }
        if(right < left){
            generate(n,left,right+1,r+")",result);
        }
        return result;
    }


    //leetcode submit region begin(Prohibit modification and deletion)
        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            return generateParenthesis(n,n,"",result);
        }

        private static List<String>  generateParenthesis(int left,int right,String parathsis, List<String> result) {
            if(left==right && 0==left){
                result.add(parathsis);
            }
            //描述生成括号的过程
            if(left > 0){
                generateParenthesis(left-1,right,parathsis+"(",result);
            }

            if(right > left){
                generateParenthesis(left,right-1,parathsis+")",result);
            }

//        错误的写法①
//        if(right>0){
//            generateParenthesis(left,right-1,parathsis+")",result);
//        }

            return result;
        }


//leetcode submit region end(Prohibit modification and deletion)

}
