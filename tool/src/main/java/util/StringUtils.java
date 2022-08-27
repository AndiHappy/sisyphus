package util;

public class StringUtils {
    public static void main(String[] args) {
        System.out.println("Keep,Happy!");
        System.out.println(palindrome("hello",1,1));
    }

    /**
     * 返回从l到r中间的回文字符串
     * */
    public  static  String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
