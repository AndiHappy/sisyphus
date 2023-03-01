package l;

public class LeetCode260 {
    /**
     * Once again, we need to use XOR (a XOR a = 0) to solve this problem.
     * But this time, we need to do it in two passes:
     * <p>
     * In the first pass, we XOR all elements in the array,
     * and get the XOR of the two numbers we need to find.
     * <p>
     * result = result1 XOR resultb;
     * <p>
     * Note that since the two numbers are distinct,
     * so there must be a set bit (that is, the bit with value '1') in the XOR result.
     * Find out an arbitrary set bit (for example, the rightmost set bit).
     * <p>
     * In the second pass, we divide all numbers into two groups,
     * one with the aforementioned bit set,
     * another with the aforementinoed bit unset.
     * Two different numbers we need to find must fall into the
     * two distrinct groups. XOR numbers in each group,
     * we can find a number in either group.
     * <p>
     * example :
     * <p>
     * no matter how much number int array ,the result of all number xor is：
     * 3 ---> 011
     * 5----> 101
     * 3^5--> 110  //result = result1 XOR resultb;
     * <p>
     * 2 ---> 010
     * 2&010 --> 010
     * 3&010 --> 010
     * <p>
     * 1---> 001
     * 1&010 --> 0
     * 5&010 --> 0
     * <p>
     * ！！神奇的划分！！！！
     * <p>
     * for each num in nums,  num & 010 ? in [2,2,3] else in [1,1,5]
     */

    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            } else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public int addDigits(int num) {

        if (num == 0) return 0;

        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }

        // one line
        // return return (num-1) % 9 + 1;
    }
}


