package l;

import util.PrintUtil;

import java.awt.print.PrinterGraphics;
import java.util.Arrays;
import java.util.HashSet;

/**

 Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

 There is only one repeated number in nums, return this repeated number.

 You must solve the problem without modifying the array nums and uses only constant extra space.



 Example 1:

 Input: nums = [1,3,4,2,2]
 Output: 2
 Example 2:

 Input: nums = [3,1,3,4,2]
 Output: 3
 Example 3:

 Input: nums = [1,1]
 Output: 1
 Example 4:

 Input: nums = [1,1,2]
 Output: 1


 Constraints:

 1 <= n <= 105
 nums.length == n + 1
 1 <= nums[i] <= n
 All the integers in nums appear only once except for precisely one integer which appears two or more times.


 Follow up:

 How can we prove that at least one duplicate number must exist in nums?
 Can you solve the problem in linear runtime complexity?

 * */
public class LeetCode287 {
    public static void main(String[] args) {
        System.out.println("keep happy");
        int[] nums= PrintUtil.oneDimensionalArray("[1,3,4,2,2]");
        PrintUtil.p(nums);
        PrintUtil.p(findDuplicate(nums));

        nums=PrintUtil.oneDimensionalArray("[1,1]");
        PrintUtil.p(findDuplicate(nums));

        nums=PrintUtil.oneDimensionalArray("[7,9,7,4,2,8,7,7,1,5]");
        PrintUtil.p(findDuplicate(nums));

    }
    public static int findDuplicate1(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            if( nums[i] == nums[i-1]){
                return nums[i-1];
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    // 二分法查找
    // 最主要的依据是：n + 1 integers where each integer is in the range [1, n] inclusive
    public static int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = (low + high) >>> 1;

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    // 当做链表来进行处理
    public int findDuplicate4(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        //寻找相遇点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //slow 从起点出发, fast 从相遇点出发, 一次走一步
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
