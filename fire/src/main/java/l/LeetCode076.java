package l;

public class LeetCode076 {

    public static void main(String[] args) {
        int i =1;
        System.out.println(++i);
    }

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

    class Solution {
        public String minWindow(String s, String t) {
            /**
             滑窗问题+数组统计
             1.这道题和LC3.最长无重复子串长度 类似，不过这一题更难一点，因为要判断窗口内是否能凑得t
             2.这种窗口内的元素能否凑成t的问题要关注数量，因此需要用HashMap或者数组来维护(A65 a97 z122)
             3.我们不妨固定一个左边界，然后右边界一直向右扫描直至首个满足窗口的元素，此时必定是该左边界为起点最短长度
             4.其他的长度必定比这个更长，因此变动左边界的情况下维护这个最短长度，并且要实时记录左右边界
             时间复杂度:O(m+n) 空间复杂度:O(1)
             */

            int lenS = s.length();
            int lenT = t.length();

            if(lenS < lenT) return "";

            int minL=0,minR=-1;
            int l=0,r=-1;
            int[] cntmap1 = new int[58];
            int[] cntmap2 = new int[58];
            //统计 t 的数据
            for(int i=0;i<lenT;i++){
                cntmap1[t.charAt(i)-'A']++;
            }

            //统计窗口有效元素的个数
            int cnt =0;
            while(l < lenS){
                //移动 r 指针直到满足要求
                while(r < lenS && cnt < lenT){
                    // 此时 r 指针加入窗口
                    ++r;
                    // 当且仅当数目小于目标值才是有效的数目
                    if(r < lenS){
                        cntmap2[s.charAt(r)-'A']++;
                        if(cntmap2[s.charAt(r)-'A'] <= cntmap1[s.charAt(r)-'A']){
                            cnt++;
                        }
                    }
                }
                //此时的窗口符合条件，若长度更小则可以更新
                if(cnt == lenT && (minR==-1 || r-l < minR-minL)){
                    minL=l;
                    minR=r;
                }

                // l指针每一轮都右移一位退出窗口
                cntmap2[s.charAt(l)-'A']--;
                if(cntmap2[s.charAt(l)-'A'] < cntmap1[s.charAt(l)-'A']){
                    cnt--;
                }
                ++l;
            }
            return minR == lenS? "": s.substring(minL,minR+1);
        }
    }
}
