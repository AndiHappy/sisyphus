package l;

public class LeetCode829 {

    /**
     *
     829. Consecutive Numbers Sum

     Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.



     Example 1:

     Input: n = 5
     Output: 2
     Explanation: 5 = 2 + 3
     Example 2:

     Input: n = 9
     Output: 3
     Explanation: 9 = 4 + 5 = 2 + 3 + 4
     Example 3:

     Input: n = 15
     Output: 4
     Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5


     Constraints:

     1 <= n <= 109

     * */


    /**
     The idea here is to understand the math behind 'consecutive sum.'

     Let's go through a few examples (here I will ignore the base case, which is the number itself)

     N = 9
     9 = 4 + 5: in this, there are two numbers that make up the sum (4 and 5).
     9 = 2 + 3 + 4: in this one, there are three numbers that make up the sum

     We can generalize this to:

     9 = x + (x + 1) + (x + 2) ... (x + n)
       = n • x + (0+1 + 2 + 3 + ... + n-1)  //greater!

     As a result, to find the numbers of consecutive sum,
     we can test how many sub-additions it can take to get to the number.
     We can iterate from 0 to n, with each iteration, subtract away the sum (1 + 2 ... etc.), and mod by n
     *
     *
     Constraints:

     1 <= n <= 109

     * */

    /**
     * 利用上面的公式：
     *      1 = 1X1 + sum(0);
     *      2 = 1X2 + sum(0);
     *      3 = 2X1 + sum(1);
     *      4 = 1X4 + sum(0);
     *      ......
     *      N =  n • x + sum(n-1)
     * */

    public static int consecutiveNumbersSum(int N) {
        int result = 1;
        int sum = 0;
        int i = 2;
        while (sum < N){
            sum += i - 1;
            // N = = i • x +  (0+1 + 2 + 3 + ... + i-1)
            // 其中的 sum 就是  (0+1 + 2 + 3 + ... + i-1)
            if ((N - sum > 0) && (N - sum) % i == 0){
                result++;
            }
            i++;
        }
        return result;
    }
// 10 = 4+3+2+1






    public static void main(String[] args) {
//        System.out.println(consecutiveSum(2) );
//        System.out.println(consecutiveSum(4));
//        System.out.println(consecutiveSum(9) );

        System.out.println(consecutiveNumbersSum(10) );
//        System.out.println(consecutiveSum(11) );
//        System.out.println(consecutiveSum(12) );
    }




}
