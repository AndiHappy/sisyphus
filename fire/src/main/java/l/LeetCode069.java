package l;

import io.netty.handler.codec.base64.Base64Decoder;

import java.util.Base64;

public class LeetCode069 {

    //Given a non-negative integer x, compute and return the square root of x.
//
// Since the return type is an integer, the decimal digits are truncated, and on
//ly the integer part of the result is returned.
//
//
// Example 1:
//
//
//Input: x = 4
//Output: 2
//
//
// Example 2:
//
//
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part is
// truncated, 2 is returned.
//
//
// Constraints:
//
//
// 0 <= x <= 231 - 1
//
// Related Topics Math Binary Search
// 👍 1985 👎 2368

    public static void main(String[] args) {
        System.out.println(new String(Base64.getDecoder().decode("aHR0cHM6Ly9jb3JkY2xvdWQuc2l0ZS9hdXRoL3JlZ2lzdGVyMT9jb2RlPU1WV3V4Z1h1UUZjRE1Rb3U5dlRBdmU0T3pUMmp0RmxL")));
        System.out.println("keep happy");
        System.out.println(mySqrt(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public static int mySqrt(int x) {
        if(0 == x)return 0;
        int left=1,right=x;
        while(true){
            int mid = left+(right-left)/2;
            if(mid >x/mid){
                right=mid;
            }else {
                if((mid+1) > x/(mid+1) ) return mid;
                left=mid+1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
