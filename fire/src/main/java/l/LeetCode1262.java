package l;

public class LeetCode1262 {
    /**
     main

     1262. 可被三整除的最大和

     给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。

     示例 1：
     输入：nums = [3,6,5,1,8]
     输出：18
     解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
     示例 2：

     输入：nums = [4]
     输出：0
     解释：4 不能被 3 整除，所以无法选出数字，返回 0。
     示例 3：

     输入：nums = [1,2,3,4,4]
     输出：12
     解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。


     提示：
     1 <= nums.length <= 4 * 10^4
     1 <= nums[i] <= 10^4
     *
     * */


    /**
     * 解题思路
     * 根据题意很容易想到用状态转移与动态规划的思路来解决
     * <p>
     * 定义
     * dp[i][0]表示nums[0...i]模三余零的最大和
     * dp[i][1]表示nums[0...i]模三余一的最大和
     * dp[i][2]表示nums[0...i]模三余二的最大和
     * 零状态：当前数字最大和模三余零
     * 一状态：当前数字最大和模三余一
     * 二状态：当前数字最大和模三余二
     * 动态规划的思路
     * 对于任意一种状态，下一步我们都有两种选择，一是选择当前元素，二是不选择当前元素
     * <p>
     * <p>
     * dp[i][*] = max{dp[i-1][*],dp[i-1][*] + nums[i]}  (* 取值为 0,1,2)
     * 以上是常见的动态规划的递推结构
     */

//    class Solution {
//        public:
//        int maxSumDivThree(vector<int>& nums) {
//            int n = nums.size();
//            vector<vector<int>> dp(n + 1, vector<int>(3, 0));
//            dp[0][0] = 0; dp[0][1] = INT_MIN; dp[0][2] = INT_MIN;
//            for (int i = 1; i <= n; i++) {
//                if (nums[i - 1] % 3 == 0) {
//                    dp[i][0] = max(dp[i - 1][0], dp[i - 1][0] + nums[i - 1]);
//                    dp[i][1] = max(dp[i - 1][1], dp[i - 1][1] + nums[i - 1]);
//                    dp[i][2] = max(dp[i - 1][2], dp[i - 1][2] + nums[i - 1]);
//                }
//                else if (nums[i - 1] % 3 == 1) {
//                    dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] + nums[i - 1]);
//                    dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + nums[i - 1]);
//                    dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + nums[i - 1]);
//                }
//                else if (nums[i - 1] % 3 == 2) {
//                    dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
//                    dp[i][1] = max(dp[i - 1][1], dp[i - 1][2] + nums[i - 1]);
//                    dp[i][2] = max(dp[i - 1][2], dp[i - 1][0] + nums[i - 1]);
//                }
//            }
//            return dp[n][0];
//        }
//    };
    public static int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length+1][3];
//        dp[i][0]表示nums[0...i]模三余零的最大和
//        dp[i][1]表示nums[0...i]模三余一的最大和
//        dp[i][2]表示nums[0...i]模三余二的最大和
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] % 3 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + nums[i - 1]);
            } else if (nums[i - 1] % 3 == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i - 1]);
            }else if (nums[i - 1] % 3 == 2) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i - 1]);
            }
        }
        return dp[nums.length][0];
    }

    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{3,6,5,1,8}));
    }

}
