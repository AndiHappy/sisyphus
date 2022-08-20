//Given an input string s and a pattern p, implement regular expression matching
// with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a pr
//evious valid character to match. 
// 
// Related Topics String Dynamic Programming Recursion 
// 👍 8791 👎 1365

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;
        // no need to initialize state[i][0] as false
        // initialize state[0][j]
        for (int j = 1; j < state[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (state[0][j - 1] || (j > 1 && state[0][j - 2])) {
                    state[0][j] = true;
                }
            }
        }
        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    state[i][j] = state[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        state[i][j] = state[i][j - 2];
                    } else {
                        state[i][j] = state[i - 1][j] || state[i][j - 1] || state[i][j - 2];
                    }
                }
            }
        }
        return state[s.length()][p.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
