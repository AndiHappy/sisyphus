package l;

import util.ListNode;

import java.util.Arrays;

public class LeetCode026 {
    /*

Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}


Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.

Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 It doesn't matter what values are set beyond the returned length.


Constraints:

0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in ascending order.
    * */


    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        if(nums.length == 1) return 1;
        // nums is sorted in ascending order.
        int i =1, result = i-1;
        while(i < nums.length){
            if(nums[i] != nums[result]){
                result++;
                nums[result]=nums[i];
            }
            i++;
        }

        return result+1;
    }

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }


    class Solution {
        /**
         1. 升序排列，原地删除出现的重复数组
         2. 如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
         原地，O(1)

         1 <= nums.length <= 3 * 104
         -104 <= nums[i] <= 104
         nums 已按 升序 排列

         */

        public int removeDuplicates(int[] nums) {
            int index=0,noDuplicatesIndex=0; int change=0;
            while(index<nums.length){
                if(nums[index] > nums[noDuplicatesIndex]){
                    //不需要交换，直接的替换即可
                    if(index > noDuplicatesIndex+1){
                        change= nums[index];
                        nums[index]= nums[noDuplicatesIndex+1];
                        nums[noDuplicatesIndex+1]=change;
                    }
                    noDuplicatesIndex++;
                }
                index++;
            }
            return noDuplicatesIndex+1;
        }
    }
}
