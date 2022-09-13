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
    // 第一：递归
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
            return isMatch_resursive(text, pattern.substring(2))
                    || (first_match && isMatch_resursive(text.substring(1), pattern));
        } else {
            return first_match && isMatch_resursive(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println("a*c".substring(2));
        System.out.println(isMatch_resursive("ab", "c*a*b"));
//        System.out.println(isMatch_resursive("b", "*b"));
    }

    public boolean isMatch(String s, String p) {
        /**
         * dp is a N+1 x M+1 matrix; N is the length of s and M is the length of p
         * dp[i][j] represents if first i characters of s match first j characters of p
         * */
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        /**
         * base case:
         * empty string s matches empty string p -> dp[0][0] = true
         * non-empty string s never match empty string p -> dp[i][0] = false
         */
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }

        /**
         * dynamic programming process
         * skip the first column because already filled as base case
         */
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (i == 0) {
                    // at the first row
                    if (p.charAt(j-1) == '*' && j > 1) {
                        /**
                         * only if jth character in p is '*', possible to evaluate to true
                         * if j == 2, dp[0][2] definitely true because '*' means can also mean 0 occurrence
                         * Similarly, if dp[i][j-2] is true, dp[i][j] is true becuase of 0 occurrence
                         */
                        dp[i][j] = (j == 2 || dp[i][j-2]);
                    } else {
                        // otherwise, a non-empty p and an empty s never match without the use of '*'
                        dp[i][j] = false;
                    }
                } else if (p.charAt(j-1) == '.') {
                    // If p's latest character is '.', dp[i][j] is equivalent to dp[i-1][j-1] because the newest characters are guaranteed to match
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    if (dp[i-1][j]) {
                        /**
                         * if p's newest chracter is '*' and dp[i-1][j] is true (this substring in p has been matching)
                         * dp[i][j] is true when the newst character in s matches the one representeed by '*': s.charAt(i-1) == p.charAt(j-2)
                         * dp[i][j] is true when the '*' represents '.': p.charAt(j-2) == '.'
                         * dp[i][j] is true when dp[i][j-2] is true because 0 occurrence of the character represented by '*'
                         **/
                        dp[i][j] = s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.' || dp[i][j-2];
                    } else {
                        /**
                         * if p's newest chracter is '*' and dp[i-1][j] is false (this substring in p hasn't matched)
                         * check if this new one gives a match: if dp[i][j-2] is true, dp[i][j] is true because of 0 occurrence of the '*' character
                         **/
                        dp[i][j] = dp[i][j-2];
                    }
                } else {
                    /**
                     * if jth character in p is just a normal letter, check if this matches with the ith character in s
                     * If they match, dp[i][j] is true only if dp[i-1][j-1] is true (same idea as palindrome)
                     */
                    dp[i][j] = dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }
        }

        return dp[s.length()][p.length()];
    }



    /**
     * To understand the approach, let’s take some examples
     *
     * s = "aa" and p = "aa", since all the character in both s and p are same, hence it’s a match.
     *
     * Now, what about s = "aabb" and p = "aab*" 🤔?
     *
     * We know that substrings bb and b* are match because * can be replaced by one b.
     * Since, we already know that remaining substrings “aa” and “aa” are match,
     * hence the whole strings also a match.
     *
     * What can we infer from this? Right, if we have solution of part of a problem, we can use that partial result and can go forward.
     * Also, we can use the already calculated result without calculating it again.
     *
     * Does this ring a bell 🔔? Yes, this problem satisfies the following two properties -
     *
     * Optimal Substructure — Any problem has optimal substructure property if its overall optimal solution can be constructed from the optimal solutions of its subproblems.
     * Overlapping Subproblems — Any problem has overlapping sub-problems if finding its solution involves solving the same subproblem multiple times.
     * It is now evident that we can use good old Dynamic Programming to solve this problem. Below are the steps —
     *
     * Create a boolean 2D dp array with sizes as
     * boolean[][] dp = new boolean[s.length() + 1][p.length() + 1].
     * We are adding extra 1 to incorporate the case in case either or both of the strings are empty.
     *
     * If both strings are empty, then it’s a match, thus, dp[0][0] = true.
     * */
    //Top-Down Variation
    public boolean isMatch_Top_to_Down(String text, String pattern) {
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
