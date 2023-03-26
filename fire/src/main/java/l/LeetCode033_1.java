package l;

public class LeetCode033_1 {

    /**

     33. Search in Rotated Sorted Array

     You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.
       给定了一个升序的数组，一个目标值
     Suppose that nums is rotated 旋转 at some pivot 轴 unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     If target is found in the array return its index, otherwise, return -1.



     Example 1:

     Input: nums = [4,5,6,7,0,1,2], target = 0
     Output: 4
     Example 2:

     Input: nums = [4,5,6,7,0,1,2], target = 3
     Output: -1
     Example 3:

     Input: nums = [1], target = 0
     Output: -1


     Constraints:

     1 <= nums.length <= 5000
     -104 <= nums[i] <= 104
     All values of nums are unique.
     nums is guaranteed to be rotated at some pivot.
     -104 <= target <= 104

     */

    public static int search(int[] nums, int target) {
        if(null == nums || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0]==target?0:-1;
        int n = nums.length;
        int l=0,r=n-1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target) return mid;
            // 前半截有序
            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    //如果最大值大于 target，则 r 需要转移到 mid 的左侧，也就是 mid-1
                    r = mid-1;
                }else{
                    //如果 target 大于最大值，也就是 target > nums[mid],那么说 target 位于右侧，也就是 l = mid+1
                    l = mid+1;
                }
            }else{
                // 后半截有序
                if(nums[mid] < target && target <= nums[n-1]){
                    // target 大于最小值，小于最大值，就在这个后半截中
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }

}