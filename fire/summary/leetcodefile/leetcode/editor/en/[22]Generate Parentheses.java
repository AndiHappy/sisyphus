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
// π 11567 π 451


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        return generateParenthesis(n,n,"",result);
    }

    private static List<String>  generateParenthesis(int left,int right,String parathsis, List<String> result) {
        if(left==right && 0==left){
            result.add(parathsis);
        }
        //ζθΏ°ηζζ¬ε·ηθΏη¨
        if(left > 0){
            generateParenthesis(left-1,right,parathsis+"(",result);
        }

        if(right > left){
            generateParenthesis(left,right-1,parathsis+")",result);
        }

//        ιθ――ηεζ³β 
//        if(right>0){
//            generateParenthesis(left,right-1,parathsis+")",result);
//        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
