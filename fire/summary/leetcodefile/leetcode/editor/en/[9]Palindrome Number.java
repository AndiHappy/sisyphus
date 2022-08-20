//Given an integer x, return true if x is palindrome integer. 
//
// An integer is a palindrome when it reads the same backward as forward. For 
//example, 121 is palindrome while 123 is not. 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it 
//becomes 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Example 4: 
//
// 
//Input: x = -101
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you solve it without converting the integer to a string? 
//Related Topics Math 👍 4184 👎 1881


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        //-2³¹ <= x <= 2³¹ - 1
        if(x < 0 ||( x % 10 == 0 && x != 0)) return false;
        if(x < 10) return true;
        int tmp =0,ini=x;
        while (x > 0){
            tmp = tmp*10 + x%10;
            if(tmp < 0) return false;
            x = x /10;
        }
        return tmp == ini;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
