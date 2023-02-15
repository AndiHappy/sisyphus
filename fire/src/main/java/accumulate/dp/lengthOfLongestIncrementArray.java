package accumulate.dp;

/**
 给你一个整数数组 nums ，找到其中最长递增子序列的长度。

 实例1：

 输入：nums = [10,9,2,5,3,7,101,18]
 输出：4
 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

 实例2：
 输入：nums = [0,1,0,3,2,3]
 输出：4
 * */
public class lengthOfLongestIncrementArray {

    //最长递增子序列
    public static int lengthofLongestIncrementArray(int[] nums){
        if(nums.length == 0) return 0;
        // 动态规划数组，dp[i]代表以位置i为末尾的最大序列长度，
        // 状态转移为：先初始化为dp[i]=1，然后遍历i前的各元素进行对比，如果大于其，说明可以作为新序列结点，递增序列可以加1，满足条件的可能有多个，
        // 不断更新dp[i]取最大值。最后根据dp不断更新最终结果。
        int[] dp = new int[nums.length-1];
        //边界初始化
        dp[0]=1;int result=1;
        //自底向上进行遍历
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;

            //从0到i遍历
            for (int j = 0; j < i; j++) {
                //找到前面比nums[i]小的数nums[j],即有dp[i]= dp[j]+1
                if (nums[j] < nums[i]) {
                    //因为会有多个小于nums[i]的数，也就是会存在多种组合了嘛，我们就取最大放到dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            //求出dp[i]后，dp最大那个就是nums的最长递增子序列啦
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public  static int lengthofLIS(int[] nums){
        if(nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];//dp[i],代表的是以i结尾的最大的递增数组的长度
        dp[0]=1;//初始化边界的条件
        int result = 1;//返回值
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;//首先是默认的值1
            //然后去更新dp[i],这个更新，是依赖于dp[i-1],dp[i-2],dp[i-3],dp[1] 最大的末尾的值的
            // dp[i-m]=k,说明以nums[i-m]结尾的最大的递增的序列的长度是：k，这个时候遍历到了i，那么
            // 如果 nums[i-m] < nums[i],nums[i]就能在dp[i-m]的最大的递增的序列后面增加nums[i],
            // 也就是说dp[i] = dp[i-m]+1
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
