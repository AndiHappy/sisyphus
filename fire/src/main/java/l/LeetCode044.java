package l;

public class LeetCode044 {
    /**
     44. 通配符匹配
     给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

     '?' 可以匹配任何单个字符。
     '*' 可以匹配任意字符串（包括空字符串）。
     两个字符串完全匹配才算匹配成功。

     说明:

     s 可能为空，且只包含从 a-z 的小写字母。
     p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     示例 1:

     输入:
     s = "aa"
     p = "a"
     输出: false
     解释: "a" 无法匹配 "aa" 整个字符串。
     示例 2:

     输入:
     s = "aa"
     p = "*"
     输出: true
     解释: '*' 可以匹配任意字符串。
     示例 3:

     输入:
     s = "cb"
     p = "?a"
     输出: false
     解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     示例 4:

     输入:
     s = "adceb"
     p = "*a*b"
     输出: true
     解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     示例 5:

     输入:
     s = "acdcb"
     p = "a*c?b"
     输出: false

     输入:
     s = "acdcb"
     p = "a*"
     输出: false

     dp[0][0]= true;
     dp[1][1] = true;
     dp[2][1] = dp[1][1]
     * */

    /**
     * 类似于以前匹配的那个字符串
     * dp[i][j] 为 s[1,,i] 1到 j 个字符是否匹配
     * 开始分析，是从左向右匹配，还是从右向左匹配。
     * 如果是从左到右进行分析：
     * 当碰到pj=*的时候 dp[i,,,S][j]都可以是true，这样就能够表示* 匹配所有的字符串
     *  如果是从右到左进行分析：
     *  就需要分析，*，前面是否有字符，判断匹配到第几个字符，有反复的，暂时采用从左到右的匹配策略
     *
     *  dp[i][j] = dp[i-1][j-1] if( s.[i-1] == p[j-1] || p[j-1] == ? )
     *
     *  s[i-1] != p[j-1]
     *      if( p[j-1] = * )  一个也不匹配   dp[i][j] = dp[i][j-1] && s[i-1] == p[j-2]
     *      if( p[j-1] = * ) 匹配一，多个     dp[i][j] = dp[i-1][j-1] || dp[i，s][j] 都是 true
     * */
    public static void main(String[] args) {
        System.out.println(isMatch("aa","*"));
        System.out.println(isMatch("cb","?a"));
        System.out.println(isMatch("adceb","*a*b"));
        System.out.println(isMatch("acdcb","a*c?b"));
    }
    public static boolean isMatch(String s, String p) {
        if((s == null || s.length() ==0 ) && (p == null || p.length() ==0)) return true;
        if( (s != null || s.length() > 0) && (p == null || p.length() ==0)) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= p.length(); i++) {
            dp[0][i] = dp[0][i-1]&&p.charAt(i-1)=='*';
        }

        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 1; j <= p.length() ; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if( p.charAt(j-1) == '*'){
                    // ......i-2,a(i-1)
                   //  .....j-2,*(j-1)
                    dp[i][j] =  dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
