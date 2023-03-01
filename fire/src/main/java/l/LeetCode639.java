package l;

public class LeetCode639 {
    /**

     A message containing letters from A-Z can be encoded into numbers using the following mapping:

     'A' -> "1"
     'B' -> "2"
     ...
     'Z' -> "26"
     To decode an encoded message,
     all the digits must be grouped then mapped back into letters using the reverse of the mapping above
     (there may be multiple ways). For example, "11106" can be mapped into:

     "AAJF" with the grouping (1 1 10 6)
     "KJF" with the grouping (11 10 6)
     Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

     In addition to the mapping above, an encoded message may contain the '*' character,
     which can represent any digit from '1' to '9' ('0' is excluded). For example,
     the encoded message "1*" may represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19".
     Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.

     Given a string s consisting of digits and '*' characters, return the number of ways to decode it.

     Since the answer may be very large, return it modulo 109 + 7.



     Example 1:

     Input: s = "*"
     Output: 9
     Explanation: The encoded message can represent any of the encoded messages "1", "2", "3", "4", "5", "6", "7", "8", or "9".
     Each of these can be decoded to the strings "A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
     Hence, there are a total of 9 ways to decode "*".
     Example 2:

     Input: s = "1*"
     Output: 18
     Explanation: The encoded message can represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19".
     Each of these encoded messages have 2 ways to be decoded (e.g. "11" can be decoded to "AA" or "K").
     Hence, there are a total of 9 * 2 = 18 ways to decode "1*".
     Example 3:

     Input: s = "2*"
     Output: 15
     Explanation: The encoded message can represent any of the encoded messages "21", "22", "23", "24", "25", "26", "27", "28", or "29".
     "21", "22", "23", "24", "25", and "26" have 2 ways of being decoded, but "27", "28", and "29" only have 1 way.
     Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15 ways to decode "2*".


     Constraints:

     1 <= s.length <= 105
     s[i] is a digit or '*'.

     * */

    public static void main(String[] args) {
        System.out.println("keep Happy boy");

    }


//    Here, I try to provide not only code but also the steps and thoughts of solving this problem completely which can also be applied to many other DP problems.
//
//            (1) Try to solve this problem in Backtracking way, because it is the most straight-forward method.
//
//    E.g '12*3'
//            12*3
//            /             \
//            12*(3)           12(*3)
//            /     \            /      \
//            12(*)(3)  1(2*)(3)  1(2)(*3)   ""
//            /    \      \       /
//            1(2)(*)(3) ""     ""     ""
//            /
//            ""
//            (2) There are many nodes visited multiple times, like 12 and 1. Most importantly, the subtree of those nodes are "exactly" the same. The backtracking solution possibly can be improved by DP. Try to merge the same nodes.
//
//            12*3
//            /  \
//            12*  |
//            | \ |
//            |  12
//            | / |
//            1   |
//            \  |
//            ""
//            (3) Successfully merge those repeated nodes and find out the optimal substructure, which is:
//
//    current state = COMBINE(next state ,  next next state)
//    e.g
//              12*
//                      / \
//    COMBINE (few different conditions)
//            /     \
//                    12      1
//    Therefore, we can solve this problem by DP in bottom-up way instead of top-down memoization.
//    Now, we formulate the optimal substructure:
//
//    dp[i] = COMBINE dp[i-1] and dp[i-2]
//    where dp[i] --> number of all possible decode ways of substring s(0 : i-1). Just keep it in mind.
//    But we need to notice there are some different conditions for this COMBINE operation.
//
//            (4) The pseudo code of solution would be:
//
//    Solution{
//        /* initial conditions */
//        dp[0] = ??
//       :
//
//        /* bottom up method */
//        foreach( i ){
//            dp[i] = COMBINE dp[i-1] and dp[i-2] ;
//        }
//
//        /* Return */
//        return dp[last];
//    }
//    The COMBINE part will be something like:
//
//            // for dp[i-1]
//            if(condition A)
//    dp[i] +=??  dp[i-1];
//    else if(condition B)
//    dp[i] +=??  dp[i-1];
//            :
//                    :
//
//                    // for dp[i-2]
//                    if(condition C)
//    dp[i] +=?? dp[i-2];
//    else if(condition D)
//    dp[i] +=?? dp[i-2];
//             :
//                     (5) The core step of this solution is to find out all possible conditions and their corresponding operation of combination.
//
//    For dp[i-1]:
//
//            /           \
//            /             \
//    s[i-1]='*'    s[i-1]>0
//            |               |
//            + 9*dp[i-1]        + dp[i-1]
//
//
//    For dp[i-2]:
//
//            /                                  \
//            /                                    \
//    s[n-2]='1'||'2'                         s[n-2]='*'
//            /            \                       /             \
//    s[n-1]='*'         s[n-1]!='*'          s[n-1]='*'       s[n-1]!='*'
//            /       \               |                  |              /         \
//    s[n-2]='1'  s[n-2]='2'   num(i-2,i-1)<=26         |         s[n-1]<=6    s[n-1]>6
//            |            |             |                  |              |            |
//            + 9*dp[i-2]   + 6*dp[i-2]     + dp[i-2]       + 15*dp[i-2]    + 2*dp[i-2]   + dp[i-2]
//            (6) Fill up the initial conditions before i = 2.
//    Because we need to check if num(i-2,i-1)<=26 for each i, we make the bottom-up process to begin from i=2. Just fill up the dp[0] and dp[1] by observation and by the definition of dp[i] --> number of all possible decode ways of substring s(0 : i-1).
//
//    dp[0]=1;
//         /      \
//    s[0]=='*'  s[0]!='*'
//            |         |
//    dp[1]=9     dp[1]=1
//            (7) The final Solution:
//
//    public int numDecodings(String s) {
//        /* initial conditions */
//        long[] dp = new long[s.length()+1];
//        dp[0] = 1;
//        if(s.charAt(0) == '0'){
//            return 0;
//        }
//        dp[1] = (s.charAt(0) == '*') ? 9 : 1;
//
//        /* bottom up method */
//        for(int i = 2; i <= s.length(); i++){
//            char first = s.charAt(i-2);
//            char second = s.charAt(i-1);
//
//            // For dp[i-1]
//            if(second == '*'){
//                dp[i] += 9*dp[i-1];
//            }else if(second > '0'){
//                dp[i] += dp[i-1];
//            }
//
//            // For dp[i-2]
//            if(first == '*'){
//                if(second == '*'){
//                    dp[i] += 15*dp[i-2];
//                }else if(second <= '6'){
//                    dp[i] += 2*dp[i-2];
//                }else{
//                    dp[i] += dp[i-2];
//                }
//            }else if(first == '1' || first == '2'){
//                if(second == '*'){
//                    if(first == '1'){
//                        dp[i] += 9*dp[i-2];
//                    }else{ // first == '2'
//                        dp[i] += 6*dp[i-2];
//                    }
//                }else if( ((first-'0')*10 + (second-'0')) <= 26 ){
//                    dp[i] += dp[i-2];
//                }
//            }
//
//            dp[i] %= 1000000007;
//        }
//        /* Return */
//        return (int)dp[s.length()];
//    }
//    P.S The space complexity can be further improved to O(1) because the current state i is only related to i-1 and i-2 during the bottom-up.

    public static  int numDecodings(String s) {
        /* initial conditions */
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;

        /* bottom up method */
        for(int i = 2; i <= s.length(); i++){
            char first = s.charAt(i-2);
            char second = s.charAt(i-1);

            // For dp[i-1]
            if(second == '*'){
                dp[i] += 9*dp[i-1];
            }else if(second > '0'){
                dp[i] += dp[i-1];
            }

            // For dp[i-2]
            if(first == '*'){
                if(second == '*'){
                    dp[i] += 15*dp[i-2];
                }else if(second <= '6'){
                    dp[i] += 2*dp[i-2];
                }else{
                    dp[i] += dp[i-2];
                }
            }else if(first == '1' || first == '2'){
                if(second == '*'){
                    if(first == '1'){
                        dp[i] += 9*dp[i-2];
                    }else{ // first == '2'
                        dp[i] += 6*dp[i-2];
                    }
                }else if( ((first-'0')*10 + (second-'0')) <= 26 ){
                    dp[i] += dp[i-2];
                }
            }

            dp[i] %= 1000000007;
        }
        /* Return */
        return (int)dp[s.length()];
    }
}
