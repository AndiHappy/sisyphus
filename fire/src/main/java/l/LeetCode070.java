package l;

public class LeetCode070 {

//You are climbing a staircase. It takes n steps to reach the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top?
//
//
// Example 1:
//
//
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//
// Example 2:
//
//
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
//
//
// Constraints:
//
//
// 1 <= n <= 45
//
// Related Topics Dynamic Programming
// 👍 6587 👎 211


    public static void main(String[] args) {
        System.out.println("keep happy");

        for (int i = 0; i < 10; i++) {
            System.out.println("i= "+i +" :"+ climbStairs(i));
        }

    }

    public static  int climbStairs(int n) {
        if(1== n) return 1;
        if(2==n) return 2;
        if(3==n) return 3;
        if(n > 3){
            int[] dp = new int[n+1];
            dp[1]=1;
            dp[2]=2;
            for (int i= 3;i <=n; i++){
                dp[i]=dp[i-1]+dp[i-2];
            }
//            PrintUtil.p(Arrays.toString(dp));
            return dp[n];
        }
        return 0;
    }
}
