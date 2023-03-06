package l;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode045 {
    /**


     45. 跳跃游戏 II

     给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

     每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

     0 <= j <= nums[i]
     i + j < n
     返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。


     示例 1:
     输入: nums = [2,3,1,1,4]
     输出: 2
     解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

     示例 2:
     输入: nums = [2,3,0,1,4]
     输出: 2

     提示:

     1 <= nums.length <= 104
     0 <= nums[i] <= 1000
     题目保证可以到达 nums[n-1]
     * */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(jumpEvery(new int[]{2,3,0,1,4})));
    }

    /**
     * 画图显示的比较的明白：
     * 2,3,0,1,4
     * 0,1,2,3,4 // 下标
     * 2,4,4,4,4 // 最大覆盖长度
     * 0,1,1,2,2
     * */
    private static int[] jumpEvery(int[] ints) {
        int maxPositon = 0;//一次能够跳到的最远的位置
        int[] steps = new int[ints.length];
        Arrays.fill(steps,-1);
        steps[0]=0; // 默认就是在这个位置
        for (int i = 1; i < ints.length; i++) {
            maxPositon = Math.max(maxPositon,ints[i-1]+i);
            for (int j = i; j < maxPositon ; j++) {
                if(steps[j] == -1){
                    steps[j]= steps[i-1]+1;
                }
            }
        }
        return steps;
    }

    public static int jump_r_1(int[] nums){
        int end = 0;
        int maxPosition=0;
        int steps=0;
        for (int i = 0; i < nums.length-1; i++) {
            maxPosition = Math.max(nums[i]+i,maxPosition);
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }
        return  steps;
    }

}
