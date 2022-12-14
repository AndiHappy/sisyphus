//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 15860 👎 1517


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * first,describe the problem
     * second, explain the problem for example
     * third, nums[-4,-1,-1,0,1,2] ,sort ,two point
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null|| nums.length <3) return result;
        Arrays.sort(nums);

        //two point interation
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j=i+1,k=nums.length-1;
            while(j < k){
                if(j>i+1 && nums[j-1] == nums[j]){
                    j++;
                    continue;
                }
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }else if(sum>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
