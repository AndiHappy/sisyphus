package l;

public class LeetCode067 {

    /**
     *
     67. Add Binary

     Given two binary strings a and b, return their sum as a binary string.



     Example 1:

     Input: a = "11", b = "1"
     Output: "100"
     Example 2:

     Input: a = "1010", b = "1011"
     Output: "10101"


     Constraints:

     1 <= a.length, b.length <= 104
     a and b consist only of '0' or '1' characters.
     Each string does not contain leading zeros except for the zero itself.
     *
     * */
    public static String addBinary(String a, String b) {
        if(null == a || a.length() == 0) return b;
        if(null == b || b.length() == 0) return a;
        StringBuilder result = new StringBuilder();
        a=a.trim();b=b.trim();
        int i=a.length()-1,j=b.length()-1,carry=0;
        while(i>=0 || j >=0){
            int iv = i>=0? (a.charAt(i)-'0'):0;
            int jv = j>=0? (b.charAt(j)-'0'):0;
            int tmpv = iv+jv+carry;
            int v= tmpv%2;
            carry=tmpv/2;
            result.insert(0,v);
            i--;j--;
        }
        if(carry>0) result.insert(0,carry);
        return result.toString();
    }

    /**
     *
     67. 二进制求和
     给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。



     示例 1：

     输入:a = "11", b = "1"
     输出："100"
     示例 2：

     输入：a = "1010", b = "1011"
     输出："10101"


     提示：

     1 <= a.length, b.length <= 104
     a 和 b 仅由字符 '0' 或 '1' 组成
     字符串如果不是 "0" ，就不含前导零

     * */

}
