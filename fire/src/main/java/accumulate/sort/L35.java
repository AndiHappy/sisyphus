package accumulate.sort;

public class L35 {
    public static void main(String[] args) {
        System.out.println("Keep moving ，man!");
//        System.out.println(searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsert(new int[]{1,3,5,6,7},2));
        System.out.println(searchInsert(new int[]{1,3,5,6,7},4));
    }

    //https://leetcode.com/problems/search-insert-position/
    //    1 <= nums.length <= 104
    //    -104 <= nums[i] <= 104
    //    nums contains distinct values sorted in ascending order.
    //    -104 <= target <= 104
    public static int searchInsert(int[] nums, int target) {
        if(nums[0] > target) return 0;
        if(nums[nums.length-1] < target) return nums.length;
        int from =0,to=nums.length-1;
        while(from <= to){
            int mid = from+ (to-from)/2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid]  > target){
                to=mid-1;
            }else{
                from= mid+1;
            }
        }
        return from;
    }

}
