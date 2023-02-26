package l;//Given a 32-bit signed integer, reverse digits of an integer.
//
// Note: 
//Assume we are dealing with an environment that could only store integers withi
//n the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this prob
//
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 

public class LeetCode007 {
    
    public static int change_1(int a) {
        int flag = a > 0 ? 1 : -1;
        if (a < 0)
            a = Math.abs(a);
        int result = 0;
        while (a > 0) {
            int tmp = a % 10;
            if (result > (Integer.MAX_VALUE - tmp) / 10) {
                return 0;
            }
            result = result * 10 + tmp;
            a = a / 10;
        }
        return result * flag;
    }

    public static int reverse(int x) {
        if(-9 < x && x < 9) return x;
        //假设环境不允许存储 64 位整数（有符号或无符号）。
        // 如果反转后整数超过 32 位的有符号整数的范围的就返回 0。
        int result=0;int pre = 0;
        boolean flag = x>0;
        x = Math.abs(x);

        while(x > 0){
            int v = x%10;
            pre = result;
            result = result*10+v;

//            if((result -v) != pre*10 ) return 0; 这么写就是错误的！！！！！！
            if((result -v)/10!= pre) return 0;

            x = x/10;
        }
        return flag? result:-result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(reverse(1534236469));// 7463847421
    }
}
