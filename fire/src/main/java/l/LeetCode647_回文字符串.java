package l;

public class LeetCode647_回文字符串 {
    /**
     647. 回文子串
     给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

     回文字符串 是正着读和倒过来读一样的字符串。

     子字符串 是字符串中的由连续字符组成的一个序列。

     具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。



     示例 1：

     输入：s = "abc"
     输出：3
     解释：三个回文子串: "a", "b", "c"
     示例 2：

     输入：s = "aaa"
     输出：6
     解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"


     提示：

     1 <= s.length <= 1000
     s 由小写英文字母组成

     * */
    private int num;
    public int countSubstrings(String s) {
        if(s.length() ==1 ) return 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count(chars,i,i);
            count(chars,i,i+1);
        }
        return num;
    }

    private void count(char[] chars, int i, int j) {
        if(i >=0 && j < chars.length){
            while (chars[i] == chars[j]){
                num++;
                i--;
                j++;
            }
        }
    }

    /**
     * 采用动态规划，避免重复计算
     * */

    class Solution {
        public int countSubstrings(String s) {
            // 动态规划法
            boolean[][] dp = new boolean[s.length()][s.length()];
            int ans = 0;

            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
