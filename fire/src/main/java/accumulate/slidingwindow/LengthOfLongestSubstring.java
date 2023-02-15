package accumulate.slidingwindow;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

    /**
     输入: s = "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * */
    public static void main(String[] args) {
        String v = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(v));
    }
    public static int lengthOfLongestSubstring(String s){
        if(s == null ) return 0;
        if(s.length() <= 1)  return s.length();
        HashMap<Character,Integer> windows = new HashMap<>();
        int fromIndex = 0;int max=1;
        for (int i = 0; i < s.length(); i++) {
                if(windows.containsKey(s.charAt(i))){
                    fromIndex = Math.max(windows.get(s.charAt(i))+1,fromIndex);
                }
                windows.put(s.charAt(i),i);
                max = Math.max(max,i-fromIndex+1);
        }
        return max;
    }

    }
