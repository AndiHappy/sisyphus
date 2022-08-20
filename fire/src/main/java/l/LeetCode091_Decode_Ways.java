package l;

public class LeetCode091_Decode_Ways {

    /**
     A message containing letters from A-Z can be encoded into numbers using the following mapping:

     'A' -> "1"
     'B' -> "2"
     ...
     'Z' -> "26"
     To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

     "AAJF" with the grouping (1 1 10 6)
     "KJF" with the grouping (11 10 6)
     Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

     Given a string s containing only digits, return the number of ways to decode it.

     The answer is guaranteed to fit in a 32-bit integer.



     Example 1:

     Input: s = "12"
     Output: 2
     Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
     Example 2:

     Input: s = "226"
     Output: 3
     Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     Example 3:

     Input: s = "0"
     Output: 0
     Explanation: There is no character that is mapped to a number starting with 0.
     The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
     Hence, there are no valid ways to decode this since all digits need to be mapped.
     Example 4:

     Input: s = "06"
     Output: 0
     Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").


     Constraints:

     1 <= s.length <= 100
     s contains only digits and may contain leading zero(s).
     * */

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        for (int i = 0; i < 101; i++) {
            if(numDecodings(String.valueOf(i)) != numDecodings1(String.valueOf(i))){
                System.out.println(numDecodings(String.valueOf(i)));
                System.out.println(numDecodings1(String.valueOf(i)));
            }
        }
    }
    public static  int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp =  new int[s.length()+1];
        dp[1]=s.charAt(0)=='0'?0:1;
        if(s.length() < 2) return dp[1];
        int va = Integer.parseInt(s.substring(0,2));
        if(s.charAt(1) == '0' ){
            if(va == 10 || va == 20) {
                dp[2]= 1;
            }else{
                dp[2]= 0;
            }
        }else {
            dp[2]= va>0&&va<27?2:1;
        }
        if(s.length() < 3) return dp[2];

        for (int i = 3; i <= s.length() ; i++) {
            int first = Integer.parseInt(s.substring(i-1,i));
            if (first >= 1 && first <= 9) {
                dp[i] = dp[i-1]+dp[i];
            }

            int second = Integer.parseInt(s.substring(i-2,i));
            if (second >= 10 && second <= 26) {
                dp[i] = dp[i-2]+dp[i];
            }
        }
        return dp[s.length()];
    }

    public static int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] = dp[i-1] + dp[i];
            }
            if (second >= 10 && second <= 26) {
                dp[i] = dp[i-2]+dp[i];
            }
        }
        return dp[n];
    }
}