package l;

public class LeetCode268 {
    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        int[] nums = new int[]{0, 1, 2};
        System.out.println(missingNumber(nums));

        nums = new int[]{3, 0, 1};
        System.out.println(missingNumber(nums));

        nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));

        nums = new int[]{9, 6, 4, 2, 3, 5, 7, 8, 1};
        System.out.println(missingNumber(nums));

        nums = new int[]{2, 0, 3};
        System.out.println(missingNumber(nums));

    }

    public int missingNumber3(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    public static int missingNumber(int[] nums) {
        int sum = 0, i = 0;
        for (; i < nums.length; i++)
            sum = sum + i - nums[i];
        return (sum + nums.length);
    }
}
