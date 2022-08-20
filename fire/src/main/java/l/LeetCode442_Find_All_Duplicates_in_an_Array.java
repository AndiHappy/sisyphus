package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode442_Find_All_Duplicates_in_an_Array {
    /**

     Given an integer array nums of length n where all the integers of nums are in the range [1, n] and
     each integer appears once or twice, return an array of all the integers that appears twice.

     You must write an algorithm that runs in O(n) time and uses only constant extra space.

     Example 1:
     Input: nums = [4,3,2,7,8,2,3,1]
     Output: [2,3]

     Example 2:
     Input: nums = [1,1,2]
     Output: [1]

     Example 3:
     Input: nums = [1]
     Output: []

     Constraints:
     n == nums.length
     1 <= n <= 105
     1 <= nums[i] <= n
     Each element in nums appears once or twice.

     *
     * */

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDuplicates(new int[]{4,3,2,7,8,2,3,1}).toArray()));

        System.out.println(Arrays.toString(findDuplicates(new int[]{1,1,2}).toArray()));

        System.out.println(Arrays.toString(findDuplicates(new int[]{1}).toArray()));

    }
}
