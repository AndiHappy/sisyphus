package l;

public class LeetCode076 {

    /***
     *
     76. Minimum Window Substring

     Given two strings s and t of lengths m and n respectively,
     return the minimum window substring of s such
     that every character in t (including duplicates) is included in the window.

     If there is no such substring, return the empty string "".

     The testcases will be generated such that the answer is unique.

     Example 1:

     Input: s = "ADOBECODEBANC", t = "ABC"
     Output: "BANC"
     Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     Example 2:

     Input: s = "a", t = "a"
     Output: "a"
     Explanation: The entire string s is the minimum window.
     Example 3:

     Input: s = "a", t = "aa"
     Output: ""
     Explanation: Both 'a's from t must be included in the window.
     Since the largest window of s only has one 'a', return empty string.

     Constraints:
     m == s.length
     n == t.length
     1 <= m, n <= 105
     s and t consist of uppercase and lowercase English letters.


     Follow up: Could you find an algorithm that runs in O(m + n) time?

     * */

    public String minWindow(String S, String T) {
        //处理特殊情况
        if(S==null||S.isEmpty()||T==null||T.isEmpty()) return "";

        int i=0, j=0;

        int[] Smap=new int[256];

        //初始化数组Tmap
        int[] Tmap=new int[256];
        for(int k=0; k< T.length(); k++){
            Tmap[T.charAt(k)]++;
        }

        int found=0;
        int length=Integer.MAX_VALUE;
        String res="";
//        一遍循环
        while(j<S.length()){

            //查找开始的j位置，found为匹配的长度，i到j为匹配的窗口的长度
            if(found<T.length()){
                if(Tmap[S.charAt(j)]>0){
                    Smap[S.charAt(j)]++;
                    if(Smap[S.charAt(j)]<=Tmap[S.charAt(j)]){
                        found++;
                    }
                }
                j++;
            }

            while(found==T.length()){
                if(j-i<length){
                    length=j-i; res=S.substring(i,j);
                }
                if(Tmap[S.charAt(i)]>0){
                    Smap[S.charAt(i)]--;
                    if(Smap[S.charAt(i)]<Tmap[S.charAt(i)]){
                        found--;
                    }
                }
                i++;
            }


        }
        return res;
    }
}
