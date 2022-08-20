package l;

import java.util.Arrays;

/**
 *
 66. Plus One

 Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.



 Example 1:

 Input: digits = [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.
 Example 2:

 Input: digits = [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.
 Example 3:

 Input: digits = [0]
 Output: [1]


 Constraints:

 1 <= digits.length <= 100
 0 <= digits[i] <= 9

 *
 * **/
public class LeetCode066_Plus_One {
    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1,9,9})));
        System.out.println(Arrays.toString(plusOne(new int[]{2,9,9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
    }

    /**
     *  思路是 数据最后一位增加1，考虑进位的问题，就行了
     *  伪代码：
     *
     *
     * */

    public static int[] plusOne(int[] digits) {
        int carry=0;
        for(int i=digits.length-1;i>=0;i--){
            int tmp = digits[i]+carry+ ((i == (digits.length-1))?1:0);
            if(tmp < 10){
                digits[i]+=1;
                return digits;
            }else{
                digits[i] = tmp%10;
                carry=tmp/10;
            }
        }

        if(carry > 0){
            int[] dest=new int[digits.length+1];
            System.arraycopy(digits,0,dest,1,digits.length);
            dest[0]=carry;
            return dest;
        }else{
            return digits;
        }
    }
}
