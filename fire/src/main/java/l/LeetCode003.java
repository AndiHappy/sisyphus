package l;

import java.util.HashMap;

public class LeetCode003 {

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
