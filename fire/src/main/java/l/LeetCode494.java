package l;

public class LeetCode494 {
    /***

     You are given an integer array nums and an integer target.

     You want to build an expression out of nums by adding one of the symbols '+' and '-'
     before each integer in nums and then concatenate all the integers.

     For example, if nums = [2, 1], you can add a '+' before 2 and a '-'
     before 1 and concatenate them to build the expression "+2-1".
     Return the number of different expressions that you can build, which evaluates to target.



     Example 1:

     Input: nums = [1,1,1,1,1], target = 3
     Output: 5
     Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
     -1 + 1 + 1 + 1 + 1 = 3
     +1 - 1 + 1 + 1 + 1 = 3
     +1 + 1 - 1 + 1 + 1 = 3
     +1 + 1 + 1 - 1 + 1 = 3
     +1 + 1 + 1 + 1 - 1 = 3
     Example 2:

     Input: nums = [1], target = 1
     Output: 1


     Constraints:

     1 <= nums.length <= 20
     0 <= nums[i] <= 1000
     0 <= sum(nums[i]) <= 1000
     -1000 <= target <= 1000
     *
     * */

    public static int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums,target,nums.length-1);
    }

    private static int findTargetSumWays(int[] nums, int target, int i) {
        if(i ==0 && nums[i] == target || -nums[i] == target){
            return 1;
        }
        if(i > 0){
            return findTargetSumWays(nums,target-nums[i],i-1) +
                    findTargetSumWays(nums,target+nums[i],i-1);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
        System.out.println(findTargetSumWays(new int[]{1},1));
    }
}
