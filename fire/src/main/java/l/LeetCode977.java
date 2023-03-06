package l;

public class LeetCode977 {
    /**
     *
     977. 有序数组的平方
     给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。



     示例 1：

     输入：nums = [-4,-1,0,3,10]
     输出：[0,1,9,16,100]
     解释：平方后，数组变为 [16,1,0,9,100]
     排序后，数组变为 [0,1,9,16,100]
     示例 2：

     输入：nums = [-7,-3,2,3,11]
     输出：[4,9,9,49,121]


     提示：

     1 <= nums.length <= 104
     -104 <= nums[i] <= 104
     nums 已按 非递减顺序 排序


     进阶：

     请你设计时间复杂度为 O(n) 的算法解决本问题
     * */
    class Solution {
        public int[] sortedSquares(int[] nums) {

            /***
             双指针，接头进行循环，谁大谁放在后面
             */
            int from=0;int to=nums.length-1;int dex =nums.length-1;
            int[] result = new int[nums.length];
            while(dex >=0 && to >=0){
                int from2 =nums[from]*nums[from];
                int to2 = nums[to]*nums[to];
                if(to2 >= from2){
                    result[dex] = to2;
                    to--;
                }else{
                    result[dex] = from2;
                    from++;
                }
                dex--;

            }
            return result;
        }
    }
}
