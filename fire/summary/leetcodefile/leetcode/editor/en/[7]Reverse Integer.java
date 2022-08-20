//Given a signed 32-bit integer x, return x with its digits reversed. If reversi
//ng x causes the value to go outside the signed 32-bit integer range [-231, 231 -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed or
// unsigned). 
//
// 
// Example 1: 
//
// 
//Input: x = 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: x = -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: x = 120
//Output: 21
// 
//
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 7820 👎 10294

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int num) {
        /**
         * first: describe the problem
         *      Assume we are dealing with an environment that could only store integers within
         *      the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this problem,
         *      assume that your function returns 0 when the reversed integer overflows.
         *
         * **/
            boolean flag = num > 0;
            num = Math.abs(num);
            int result = 0,cur=0;
            while(num >0){
                result = cur*10+num%10;
                if((result-num%10)/10 != cur){
                    return 0;
                }
                cur=result;
                num = num/10;
            }
            return flag?result:-result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
