package l;

import util.PrintUtil;

public class LeetCode283 {
    public static void main(String[] args) {
        System.out.println("keep happy");
        int[] nums = PrintUtil.oneDimensionalArray("[0,1,0,3,12]");
        PrintUtil.p(nums);
        moveZeroes(nums);
        PrintUtil.p(nums);
    }

    public static void moveZeroes(int[] nums) {
        if(nums==null || nums.length < 2) return;
        int lastNot0index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[lastNot0index];
                nums[lastNot0index]=tmp;
                lastNot0index++;
            }
        }
    }
}
