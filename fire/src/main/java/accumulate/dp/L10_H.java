package accumulate.dp;

public class L10_H {

    /**
     * first : describe the problem
     * Given an input string s and a pattern p, implement regular expression matching
     * with support for '.' and '*' where:
     * '.' Matches any single character
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     * */

    /**
     * 1 <= s.length <= 20
     * 1 <= p.length <= 30
     * s contains only lowercase English letters.
     * p contains only lowercase English letters, '.', and '*'.
     * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
     */

    //-----------------------------------------------------------------------------------
    // 介绍
    // If there were no Kleene stars (the * wildcard character for regular expressions),
    // the problem would be easier - we simply check from left to right if each character of the text matches the pattern.
    // 如果没有*号，我们只需要一个一个字符的比对就行了，就像如下的代码，为了方便，我们写成迭代的方式
    public static boolean isMath_noKleeneStars(String s, String p) {
        if (p == null || p.isEmpty()) return s == null || s.isEmpty();
        boolean isMath = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
        if (p.length() > 1) {
            return isMath && isMatch_resursive(s.substring(1), p.substring(1));
        }
        return isMath;
    }

    /**
     * When a star is present, we may need to check many different suffixes of the text
     * and see if they match the rest of the pattern.
     * <p>
     * A recursive solution is a straightforward way to represent this relationship.
     */

    public static boolean isMatch_resursive(String text, String pattern) {
        if (pattern == null || pattern.isEmpty()) return text == null || text.isEmpty();
        /**
         * 逗号的出现，非常的好理解和解决，就是任意的匹配一个字符，就完事了
         * */
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        /**
         * 符号*的描述是:Matches zero or more of the preceding element
         * 匹配0个，很好的解释，
         * */
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch_resursive(text, pattern.substring(2)) || (first_match && isMatch_resursive(text.substring(1),
                    pattern));
        } else {
            return first_match && isMatch_resursive(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch_resursive("ab", "a*b"));
        System.out.println(isMatch_resursive("b", "*b"));

    }

    //Top-Down Variation
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

    enum Result {
        TRUE, FALSE
    }

    class Solution {

        Result[][] memo;

        //Bottom-Up Variation
        public boolean isMatch(String text, String pattern) {
            memo = new Result[text.length() + 1][pattern.length() + 1];
            return dp(0, 0, text, pattern);
        }

        public boolean dp(int i, int j, String text, String pattern) {
            if (memo[i][j] != null) {
                return memo[i][j] == Result.TRUE;
            }
            boolean ans;
            if (j == pattern.length()) {
                ans = i == text.length();
            } else {
                boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    ans = (dp(i, j + 2, text, pattern) || first_match && dp(i + 1, j, text, pattern));
                } else {
                    ans = first_match && dp(i + 1, j + 1, text, pattern);
                }
            }
            memo[i][j] = ans ? Result.TRUE : Result.FALSE;
            return ans;
        }
    }
}
