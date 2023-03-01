package l;

public class LeetCode035 {

    /**
     * LeetCode:35 Search Insert Position
     *

     Given a sorted array of distinct integers and a target value, return the index

     if the target is found. If not, return the index where it would be if it were i nserted in order.

     Example 1:
     Input: nums = [1,3,5,6], target = 5
     Output: 2

     Example 2:
     Input: nums = [1,3,5,6], target = 2
     Output: 1

     Example 3:
     Input: nums = [1,3,5,6], target = 7
     Output: 4

     Example 4:
     Input: nums = [1,3,5,6], target = 0
     Output: 0

     Example 5:
     Input: nums = [1], target = 0
     Output: 0


      Constraints:
      1 <= nums.length <= 104
     -104 <= nums[i] <= 104
     nums contains distinct values sorted in ascending order.
     -104 <= target <= 104

     *
     *
     * */

    public static int searchInsert(int[] nums, int target) {
        if(null == nums || nums.length == 0 || nums[0] >= target ) return 0;
        int fIndex = 0,eIndex=nums.length-1;
        while(fIndex <= eIndex){
            int mid = fIndex+(eIndex-fIndex)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target){
                fIndex = mid+1;
            }else {
                eIndex = mid-1;
            }
        }

        return fIndex;
    }


    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
        System.out.println(searchInsert(new int[]{1,3,5,6},7));
        System.out.println(searchInsert(new int[]{1,3,5,6},0));

    }


    class Solution {
        // 具体的内容的参考，怎么样，能够直接的学会
        // 能够应对所有的题目和内容,自己已经开始想一次性干完了，这个样的话，它就会变为一个证书一样的东西了
        // 开始弄，然后在开始干活的基础上，进行尝试，自己就是要开始干活了啊，不能再这里闲置了
        public int searchInsert(int[] nums, int target) {
            int from =  0;
            int to = nums.length;
            while(from <= to && from < nums.length && to >= 0){
                int mid = from + (to-from)/2;
                if(nums[mid] > target){
                    to=mid-1;
                }else if(nums[mid] == target){
                    return mid;
                }else{
                    from = mid +1;
                }
            }
            return from;
        }
    }
}
