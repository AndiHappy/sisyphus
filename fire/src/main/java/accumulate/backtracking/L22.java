package accumulate.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {

            System.out.println(Arrays.toString(generateParenthesis(3).toArray()));
    }
//leetcode submit region end(Prohibit modification and deletion)

}
