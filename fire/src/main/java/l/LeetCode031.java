package l;

public class LeetCode031 {

    /**

     Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

     If such an arrangement is not possible, it must rearrange it
     as the lowest possible order (i.e., sorted in ascending order).

     The replacement must be in place and use only constant extra memory.


     Example 1:

     Input: nums = [1,2,3]
     Output: [1,3,2]
     Example 2:

     Input: nums = [3,2,1]
     Output: [1,2,3]
     Example 3:

     Input: nums = [1,1,5]
     Output: [1,5,1]
     Example 4:

     Input: nums = [1]
     Output: [1]


     Constraints:

     1 <= nums.length <= 100
     0 <= nums[i] <= 100

     * */

    // 依据： https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = nums.length - 2;

        while(i >= 0 && nums[i] >= nums[i + 1]) i--; // Find 1st id i that breaks descending order

        if(i >= 0) {                           // If not entirely descending
            int j = nums.length - 1;              // Start from the end
            while(nums[j] <= nums[i]) j--;           // Find rightmost first larger id j
            swap(nums, i, j);                     // Switch i and j
        }
        reverse(nums, i + 1, nums.length - 1);       // Reverse the descending sequence
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }

    public static void main(String[] args) {
        System.out.println("keep Happy boy");

    }

    /**

     31. 下一个排列
     整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。

     例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

     例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     给你一个整数数组 nums ，找出 nums 的下一个排列。
     必须 原地 修改，只允许使用额外常数空间。
     示例 1：

     输入：nums = [1,2,3]
     输出：[1,3,2]
     示例 2：

     输入：nums = [3,2,1]
     输出：[1,2,3]
     示例 3：

     输入：nums = [1,1,5]
     输出：[1,5,1]


     提示：

     1 <= nums.length <= 100
     0 <= nums[i] <= 100
     * */

    class Solution {
        /***

         题干的意思是：找出这个数组排序出的所有数中，刚好比当前数大的那个数

         比如当前 nums = [1,2,3]。这个数是123，找出1，2，3这3个数字排序可能的所有数，排序后，
         比123大的那个数 也就是132

         如果当前 nums = [3,2,1]。这就是1，2，3所有排序中最大的那个数，那么就返回1，2，3排序后所有数中最小的那个，
         也就是1，2，3 -> [1,2,3]

         首先看举得例子：
         arr = [1,2,3] 的下一个排列是 [1,3,2]
         arr = [2,3,1] 的下一个排列是 [3,1,2]
         arr = [3,2,1] 的下一个排列是 [1,2,3]

         一直觉得排列的题目很有趣，终于想通了根据当前排列计算出下一个排列的方法，在这里记录一下。
         例如 2, 6, 3, 5, 4, 1 这个排列， 我们想要找到下一个刚好比他大的排列，于是可以:
         从后往前看 我们先看后两位 4, 1 能否组成更大的排列，答案是不可以，同理 5, 4, 1也不可以
         直到3, 5, 4, 1这个排列，因为 3 < 5， 我们可以通过重新排列这一段数字，来得到下一个排列

         因为我们需要使得新的排列尽量小，所以我们从后往前找第一个比3更大的数字，发现是4 然后，我们调换3和4的位置，
         得到4, 5, 3, 1这个数列 因为我们需要使得新生成的数列尽量小，
         于是我们可以对5, 3, 1进行排序，
         可以发现在这个算法中，我们得到的末尾数字一定是倒序排列的，
         于是我们只需要把它反转即可 最终，我们得到了4, 1, 3, 5这个数列 完整的数列则是2, 6, 4, 1, 3, 5

         */
        public int[] nextPermutation(int[] nums) {
            if(nums.length <= 1) return null;
            //首先从后向前，找到那个升序中断点
            int index = nums.length-1;
            while(index >0){
                if(nums[index-1] < nums[index]){
                    break;
                }
                index--;
            }
            index = index-1;
            if(index < 0) {
                nums=reverseArray(nums,0,nums.length-1);
            }else{
                // 寻找index的替换的位置
                int swap =nums.length-1;
                while(nums[swap] <= nums[index])swap--;
                nums = swap(nums,swap,index);
                //再去翻转后续的序列
                nums = reverseArray(nums,index+1,nums.length-1);
            }
            return nums;
        }

        public int[] reverseArray(int[] nums,int from,int to){
            int tmp = 0;
            while(from < to && to >=0 && from< nums.length-1){
                tmp = nums[from];
                nums[from] =nums[to];
                nums[to]=tmp;
                from++;
                to--;
            }
            return nums;
        }

        public int[] swap(int[] nums,int from,int to){
            int tmp = nums[from];
            nums[from] =nums[to];
            nums[to]=tmp;
            return nums;
        }
    }
}
