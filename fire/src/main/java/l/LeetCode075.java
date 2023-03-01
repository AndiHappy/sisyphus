package l;

import util.PrintUtil;

public class LeetCode075 {
    //Given an array nums with n objects colored red, white, or blue, sort them in-p
//lace so that objects of the same color are adjacent, with the colors in the orde
//r red, white, and blue.
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and b
//lue, respectively.
//
// You must solve this problem without using the library's sort function.
//
//
// Example 1:
// Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// Example 2:
// Input: nums = [2,0,1]
//Output: [0,1,2]
// Example 3:
// Input: nums = [0]
//Output: [0]
// Example 4:
// Input: nums = [1]
//Output: [1]
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 300
// nums[i] is 0, 1, or 2.
//
//
//
// Follow up: Could you come up with a one-pass algorithm using only constant ex
//tra space?
// Related Topics Array Two Pointers Sort
// 👍 5421 👎 310

    /**
     * [a,a,..,b,b,b....c,c,c]
     * */
    public static void sortColors(int[] nums) {

        int from0=0;
        int end2=nums.length-1;
        int i = 0;

        while(i < nums.length){
            int value = nums[i];

            if(0 == value) {

                if(i > from0){
                    chang(i,from0,nums);
                    from0++;
                }else{
                    i++;
                }

            }else if(2 == value){

                if(i < end2){
                    chang(i,end2,nums);
                    end2--;
                }else{
                    i++;
                }

            }else{
                i++;
            }

        }
    }

    private static void chang(int i, int from0, int[] nums) {
        int tmp = nums[i];
        nums[i]=nums[from0];
        nums[from0]=tmp;
    }

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        int[] test = new int[]{1,2,0};
        sortColors(test);
        PrintUtil.p(test);

        PrintUtil.pLine();
        test = new int[]{0,0,0,1,1,0};
        sortColors(test);
        PrintUtil.p(test);

        PrintUtil.pLine();
        test = new int[]{0,0,0,0,0,0};
        sortColors(test);
        PrintUtil.p(test);


        PrintUtil.pLine();
        test = new int[]{1,1,1,1};
        sortColors(test);
        PrintUtil.p(test);

        PrintUtil.pLine();
        test = new int[]{2,2,2,1};
        sortColors(test);
        PrintUtil.p(test);
    }
}
