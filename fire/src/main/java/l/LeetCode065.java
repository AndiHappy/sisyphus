package l;

public class LeetCode065 {

    /**
     * 65. Valid Number
     * <p>
     * A valid number can be split up into these components (in order):
     * <p>
     * A decimal number or an integer.
     * (Optional) An 'e' or 'E', followed by an integer.
     * A decimal number can be split up into these components (in order):
     * <p>
     * (Optional) A sign character (either '+' or '-').
     * One of the following formats:
     * At least one digit, followed by a dot '.'.
     * At least one digit, followed by a dot '.', followed by at least one digit.
     * A dot '.', followed by at least one digit.
     * An integer can be split up into these components (in order):
     * <p>
     * (Optional) A sign character (either '+' or '-').
     * At least one digit.
     * For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
     * <p>
     * Given a string s, return true if s is a valid number.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "0"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "e"
     * Output: false
     * Example 3:
     * <p>
     * Input: s = "."
     * Output: false
     * Example 4:
     * <p>
     * Input: s = ".1"
     * Output: true
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 20
     * s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
     */


    public static boolean validate(String string) {
        String s = string.trim();
        boolean digitSeen = false;
        boolean digitAfterESeen = true;
        boolean ditSeen = false;
        boolean ESeen = false;
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if ('0' <= cur && cur <= '9') {
                digitSeen = true;
                digitAfterESeen = true;
            } else if ('.' == cur) {
                //  (Optional) An 'e' or 'E', followed by an integer.
                //  E 之后，只能是 integer，不能出现.
                if (ditSeen || ESeen) {
                    return false;
                }
                ditSeen = true;
            } else if ('e' == cur || 'E' == cur) {
                // ee，1e formate，
                // e3 formate
                if (ESeen || !digitSeen) {
                    return false;
                }
                ESeen = true;
                digitAfterESeen = false;
            } else if ('+' == cur || '-' == cur) {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return digitSeen && digitAfterESeen;
    }

    /**
     * 65. 有效数字
     * 有效数字（按顺序）可以分成以下几个部分：
     * <p>
     * 一个 小数 或者 整数
     * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
     * 小数（按顺序）可以分成以下几个部分：
     * <p>
     * （可选）一个符号字符（'+' 或 '-'）
     * 下述格式之一：
     * 至少一位数字，后面跟着一个点 '.'
     * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     * 一个点 '.' ，后面跟着至少一位数字
     * 整数（按顺序）可以分成以下几个部分：
     * <p>
     * （可选）一个符号字符（'+' 或 '-'）
     * 至少一位数字
     * 部分有效数字列举如下：["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
     * <p>
     * 部分无效数字列举如下：["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
     * <p>
     * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "0"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：s = "e"
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：s = "."
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 20
     * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
     */

    static class Solution {
        public boolean isNumber(String s) {
            if (s.length() == 1) return Character.isDigit(s.charAt(0));

            boolean signal = false;
            //首先是符号位的确认
            int i = 0;
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                i++;
                signal = true;
            }


            boolean numSeen = false;
            boolean numBeforePoint = false;
            boolean numAfterPoint = false;
            boolean seenPoint = false;
            boolean numBeforeE = false;
            boolean numAfterE = false;
            boolean seenE = false;
            boolean signalAfterE = false;
            while (i < s.length()) {
                if (Character.isDigit(s.charAt(i))) {
                    if (seenPoint) {
                        numAfterPoint = true;
                    } else {
                        numBeforePoint = true;
                    }

                    if (seenE) {
                        numAfterE = true;
                    } else {
                        numBeforeE = true;
                    }
                    numSeen = true;
                    i++;
                } else if (s.charAt(i) == '.') {
                    if (seenE || seenPoint) return false;
                    seenPoint = true;
                    i++;
                } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                    if (seenE) return false;
                    seenE = true;
                    i++;
                } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    if (seenE && !signalAfterE && !numAfterE) {
                        signalAfterE = true;
                    } else {
                        return false;
                    }
                    i++;
                } else {
                    return false;
                }
            }

            if (seenE) {
                if (!numBeforeE || !numAfterE) return false;
            }
            return numSeen;
        }
    }


    public static void main(String[] args) {
        LeetCode065.Solution test = new LeetCode065.Solution();
        String[] t = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        for (int i = 0; i < t.length; i++) {
            if (test.isNumber(t[i])) {
                System.out.println(t[i] + " " + test.isNumber(t[i]));
            } else {
                System.out.println(t[i] + " " + test.isNumber(t[i]));
            }

        }

        t = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", "..2"};
        for (int i = 0; i < t.length; i++) {
            if (test.isNumber(t[i])) {
                System.out.println(t[i] + " " + test.isNumber(t[i]));
            } else {
                System.out.println(t[i] + " " + test.isNumber(t[i]));
            }

        }
    }
}
