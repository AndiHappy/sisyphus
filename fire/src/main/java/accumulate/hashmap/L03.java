package accumulate.hashmap;

import java.util.HashMap;

public class L03 {

    /**
     * first: describe the problem
     *      Given a string s, find the length of the longest substring without repeating c
     * second: use data structure
     *      hashmap
     * third: write the code
     * fouth: test the case
     * */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() ==1 ) return 1;
        HashMap<Character,Integer> window = new HashMap<>(s.length());
        int from = 0;int result=0;
        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            if(window.containsKey(tmp)){
                from = window.get(tmp) >= from ? window.get(tmp)+1:from;
            }
            window.put(tmp,i);
            result = Math.max(result,(i-from+1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaaa"));
        System.out.println(lengthOfLongestSubstring("ababab"));
        System.out.println(lengthOfLongestSubstring("ababccdefgaba"));
    }
}
