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
public class LeetCode066 {
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


    /**
     66. 加一
     给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

     你可以假设除了整数 0 之外，这个整数不会以零开头。



     示例 1：

     输入：digits = [1,2,3]
     输出：[1,2,4]
     解释：输入数组表示数字 123。
     示例 2：

     输入：digits = [4,3,2,1]
     输出：[4,3,2,2]
     解释：输入数组表示数字 4321。
     示例 3：

     输入：digits = [0]
     输出：[1]


     提示：

     1 <= digits.length <= 100
     0 <= digits[i] <= 9
     * */

    class Solution {
        /***

         **/
        public int[] plusOne(int[] digits) {

            int carry = 0;
            for(int i = digits.length-1;i>=0;i--){
                int tmp = carry+ digits[i]+ (i==digits.length-1?1:0);
                if(tmp < 10){
                    carry=0;
                    digits[i] = tmp;
                }else{
                    carry = 1;
                    digits[i] = 0;
                }
                if(carry <=0){
                    return digits;
                }
            }

            if(carry >0){
                int[] dest=new int[digits.length+1];
                System.arraycopy(digits,0,dest,1,digits.length);
                dest[0]=carry;
                return dest;
            }
            return null;
        }

        //优化一下
        public int[] plusOne_good(int[] digits) {

            int carry = 0;
            for(int i = digits.length-1;i>=0;i--){
                int tmp = carry+ digits[i]+ (i==digits.length-1?1:0);
                if(tmp < 10){
                    carry=0;
                    digits[i] = tmp;
                }else{
                    carry = 1;
                    digits[i] = 0;
                }
                if(carry <=0){
                    return digits;
                }
            }

            if(carry >0){
                int[] dest=new int[digits.length+1];
//                System.arraycopy(digits,0,dest,1,digits.length);
                dest[0]=1;
                return dest;
            }
            return null;
        }
    }




}
