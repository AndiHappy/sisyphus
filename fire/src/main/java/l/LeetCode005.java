package l;
//Given a string s, return the longest palindromic substring in s.
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//

public class LeetCode005 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int max = 0, from = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = findLongestPalindrome(s, i, i);
            if (max < len) {
                max = len;
                from = i - (len - 1);
            }
            int len2 = findLongestPalindrome(s, i, i + 1);
            if (max < len2) {
                max = len2;
                from = i - (len2 - 1);
            }
        }
        return s.substring(from, from + 2 * max - 1);
    }

    private static int findLongestPalindrome(String s, int i, int i2) {
        int length = 0;
        while (i > -1 && i2 < s.length()) {
            if (s.charAt(i) == s.charAt(i2)) {
                length++;
            } else {
                break;
            }
            i--;
            i2++;
        }
        return length;
    }

    public static String longestPalindrome_dp(String s) {
        if (s == null || s.length() < 2)
            return s;
        int i = s.length();
        int max = 0, from = 0, to = 0;
        boolean[][] dp = new boolean[i][i];
        for (int j = dp.length - 1; j >= 0; j--) {
            for (int j2 = j; j2 < dp.length; j2++) {
                dp[j][j2] = (j2 - j <= 1 && s.charAt(j) == s.charAt(j2))
                        || (dp[j + 1][j2 - 1] && s.charAt(j) == s.charAt(j2));
                if (dp[j][j2] && (j2 - j + 1 >= max)) {
                    max = j2 - j + 1;
                    from = j;
                    to = j2;
                }
            }
        }
        return s.substring(from, to + 1);
    }


    // Longest Palindromic Substring
    // dp 解法
    // dp[i][j] from i to j is palindromic substring
    // dp[i][i]=true
    // dp[i][j]= 【charAt(i) == charAt(j) && j-i == 1 】|| 【charAt(i) == charAt(j) &&
    // dp[i+1][j-1] && i,j 不越界】
    public static String longestPalindrome_1(String a) {

        if (a == null || a.length() < 2) return a;
        boolean[][] dp = new boolean[a.length()][a.length()];
        int start = 0, end = 0;
        for (int i = 0; i < a.length(); i++) dp[i][i] = true;
        for (int i = a.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < a.length(); j++) {
                if (a.charAt(i) == a.charAt(j)
                        && (j - i == 1
                        || (i < a.length() - 1 && j > 0 && dp[i + 1][j - 1])
                )) {
                    dp[i][j] = true;
                    if (j - i > (end - start)) {
                        start = i;
                        end = j;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return a.substring(start, end + 1);
    }



    static class Solution {
        //最长回文字符串，abcdcba ， 或者 adda
        //如果一个字符串是回文字符串，也即是说字符串 i到j为回文字符串
        // dp[i,j]为回文字符串 那么 dp[i-1,j+1] 如果 s[i-1] == s[j+1]
        // 如果dp[i,j]不为回文字符串，那么 dp[i-1,j+1]也就不会是回文字符串
        // 为什么翻译的代码的时候，感觉不到那个面对easy题目的得心应手尼
        public String longestPalindrome(String s) {
            if(s==null || s.length() <=1) return s;
            //初始化
            boolean[][] dp = new boolean[s.length()][s.length()];
            for(int i=0;i<s.length();i++){
                dp[i][i]=true;
            }
            // 返回值
            int result= 1;
            int start = 0;int end=0;

            //倒序的设置dp
            for(int i=s.length()-1;i>=0;i--){
                for(int j=i;j<s.length();j++){
                    dp[i][j] = s.charAt(i) == s.charAt(j)
                            && (j-i <= 2 || (j>0 && i<s.length()-1 && dp[i+1][j-1]));
                    if(dp[i][j] && result > (i-j+1)){
                        result = i-j+1;
                        start=i;end=j;
                    }
                }
            }
            return s.substring(start,end+1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("cabac"));
//        System.out.println(longestPalindrome_dp("cabac"));
//        System.out.println(longestPalindrome("caddac"));
//        System.out.println(longestPalindrome_dp("cabac"));
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome_dp("babad"));

        LeetCode005.Solution s = new LeetCode005.Solution();
        s.longestPalindrome("bbbb");
    }

}
