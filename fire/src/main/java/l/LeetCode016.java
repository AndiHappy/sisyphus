package l;
//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution.
//
//
// Example 1:
//
//
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//
//
// Constraints:
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics Array Two Pointers


import java.util.Arrays;

public class LeetCode016 {

    class Solution {

        // 最接近的三数之和
        public int threeSumClosest(int[] nums, int target) {
            //3 <= nums.length <= 1000
            // -1000 <= nums[i] <= 1000
            // -104 <= target <= 104
            int closetest = Integer.MAX_VALUE;
            int result=0;
            Arrays.sort(nums);
            int i =0;
            while(i < nums.length-2){
                if( i > 0 && (nums[i] == nums[i-1])){
                    i++;
                    continue;
                }
                int j=i+1;int k = nums.length-1;
                while(j < k){

                    if(j >i+1 && nums[j] == nums[j-1]){
                        j++;
                        continue;
                    }

                    int value = nums[i]+nums[j]+nums[k];
                    if(value == target){
                        return target;
                    }else if(value < target){
                        j++;
                        int closet = Math.abs(target - value);
                        if(closet < closetest){
                            closetest =closet;
                            result = value;
                        }
                    }else{
                        k--;
                        int closet = Math.abs(target - value);
                        if(closet < closetest){
                            closetest =closet;
                            result = value;
                        }
                    }
                }
                i++;
            }

            return result;

        }
    }

    public static int threeSumClosest(int[] nums, int target) {
        Integer result = 0;
        Integer distance = Integer.MAX_VALUE;
        // 3 <= nums.length <= 10^3,so not check args
        // first sort
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // skip same elements
            if(i>0 && nums[i-1] == nums[i]) continue;
            int j = i+1;int k = nums.length-1;
            while(j < k){
                if(j>i+1 && nums[j-1] == nums[j]){
                    j++;
                    continue;
                }
                int tmpSum = nums[i]+nums[j]+nums[k];
                if(tmpSum == target){
                    return target;
                }else if(tmpSum < target){
                    j++;
                    int compare = Math.abs(target-tmpSum);
                    if(compare < distance) {
                        distance= compare;
                        result = tmpSum;
                    }
                }else{
                    k--;
                    int compare = Math.abs(target-tmpSum);
                    if(compare < distance) {
                        distance= compare;
                        result = tmpSum;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
        System.out.println(threeSumClosest(new int[]{-1,2,5,-4,},1));

    }

}
