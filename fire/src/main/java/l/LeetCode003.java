package l;

import java.util.HashMap;

public class LeetCode003 {

    /**
     3. 无重复字符的最长子串
     给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

     示例 1:

     输入: s = "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:

     输入: s = "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:

     输入: s = "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


     提示：

     0 <= s.length <= 5 * 104
     s 由英文字母、数字、符号和空格组成

     *
     * */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() ==1 ) return 1;
        HashMap<Character,Integer> window = new HashMap<>(s.length());
        int from = 0;int result=0;
        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            if(window.containsKey(tmp)){
                // 不能只顾一时，运行的情况千千万，需要归类进行约束
                from = window.get(tmp) >= from ? window.get(tmp)+1:from;
            }
            window.put(tmp,i);
            result = Math.max(result,(i-from+1));
        }
        return result;
    }
}
