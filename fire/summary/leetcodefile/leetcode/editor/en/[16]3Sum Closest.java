//Given an integer array nums of length n and an integer target, find three inte
//gers in nums such that the sum is closest to target. 
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
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
// Example 2: 
//
// 
//Input: nums = [0,0,0], target = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -104 <= target <= 104 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 5198 👎 230


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        // first sort the nums
        Arrays.sort(nums);
        Integer resuult = null;
        // second two index
        for(int i =0;i< nums.length;i++){
            if(i !=0 && nums[i-1] == nums[i]) continue;
            int fromindex = i+1,endinex = nums.length-1;
            while(fromindex < endinex){
                int tmpTarget = nums[fromindex]+nums[endinex]+nums[i];
                if(resuult == null || Math.abs(tmpTarget-target) < Math.abs(resuult-target)){
                    resuult=tmpTarget;
                }
                if(target == tmpTarget){
                    return target;
                }else if(target > tmpTarget){
                    fromindex++;
                    while (endinex > fromindex && nums[fromindex - 1] == nums[fromindex])
                        fromindex++;
                }else{
                    endinex--;
                    while (endinex > fromindex && nums[endinex + 1] == nums[endinex])
                        endinex--;

                }
            }
        }
        return resuult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
