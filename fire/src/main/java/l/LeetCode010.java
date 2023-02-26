package l;
//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*' where: 
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
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a pr
//evious valid character to match.
//
// Related Topics String Dynamic Programming Backtracking

public class LeetCode010 {

    /**
     * 再次的去理解
     * */
    public static  boolean isMatch(String s ,String p){
        /**
         * 首先确定是从左到右进行分析，还是从右到左的进行分析
         * 从左到右进行分析：字符后面是否跟着*会影响结果，分析起来有点复杂
         *      aab
         *      c*a*b
         *      从左到右进行分析，a与c不匹配，但还要看c后面有没有跟着*号，*出现可以把c干掉，出现了0次c
         *
         * 从右到左进行进行分析，星号的前面肯定有一个字符，星号也只影响这一个字符，它也只能影响这一个字符，复制几次，0次，1次到n次。
         * 在题干中出现的描述：保证每次出现字符 * 时，前面都匹配到有效的字符，也有隐隐的提示作用
         *
         *      aab
         *      c*a*b
         *      从右向左分析，b则相等，a* 的这个*只能影响a被复制几次，c*的这个*也只能影响c被复制了几次
         *
         * 这样的话，s,p是否匹配，就取决于：最右端是否匹配，剩下的子串是否匹配
         * 只是最右端可能是特殊符号的，需要分类进行讨论
         *
         * 通用地表示出子问题
         *      大子串是否匹配，和剩余子串是否匹配，是规模不一样的同一问题。
         *      s(0,i) 下标从0到i的串 --> i个字符子串
         *      p(0,j) 下标从0到j的串 --> j个字符子串
         *
         *      i个字符子串 是否匹配 j个字符子串
         *
         *      s(0,i-1) 是否匹配 p(0,j-1) 使用dp[i][j]
         *
         *      情况一：如果：s[i-1] == p[j-1] || p[j-1]= '.' 则 dp[i][j] = dp[i-1][j-1]
         *
         *      情况二：如果： s[i-1] != p[j-1] , 则不能判断s,p不匹配；dp[i][j]=false，可能是p[j-1]等于* 引起的不匹配
         *
         *      如果p[j-1]不等于*，则可以直接排除死刑，因为已经没有办法抢救了。 现在就差 p[j-1]等于*的情况说明
         *
         *      如果p[j-1]等于*,且 s[i-1]和p[j-2]匹配，要考虑三种情况：
         *         p[j-1]星号可以让p[j-2]在p串中消失，出现1次，出现>=2次
         *         只要其中一种使得剩余的子串进行匹配，那就能匹配。
         *         s[0,......i-2,i-1]
         *         p[0,.....j-3,j-2,*] 如果*表示复制0次，也就 p中的 [j-2,*]不在出现，则需要考察的是s(0,i-1) 和 p(0,j-3) 也就是dp[i][j-2]
         *
         *         s[0,......i-2,i-1]
         *         p[0,.....j-3,j-2,*] 如果*表示复制1次，也就是 p中的[j-2,*]出现一次,则需要考察的是s(0,i-2) 和 p(0,j-3)也就是dp[i-1][j-2]
         *
         *         s[0,......i-2,i-1]
         *         p[0,.....j-3,j-2,(*)] 如果*表示复制多次，也就是 p中[j-2,*]*出现多次,那我们就是在p中出现了很多次的j-1,我们拿出了一个j-1和i-1进行抵消
         *         还有剩下的j-1一样存在，则需要考察的是s(0,i-2) 和 p(0,j-1)也就是dp[i-1][j]
         *
         *     如果p[j-1]等于*,且 s[i-1]和p[j-2]不匹配，要考虑情况如下：
         *          s[0,......i-2,i-1]
         *          p[0,.....j-3,j-2,*]
         *          这种情况下， s[i-1]和p[j-2]不匹配，就需要把p[j-2,*]直接的消掉，才能继续匹配，不然就要返回false了，消掉p[j-2,*]，也就是需要考虑s(0,i-1) 和 p(0,j-3)
         *          也就是dp[i][j-2]
         *
         *   还有一些特殊的情况：
         *      s,p都是空串，则匹配。dp[0][0]=true;
         *      p为空串，s不是空串，肯定不匹配  dp[i][0]=false
         *      p不为空串，s为空串，要想匹配只能最右端是星号，这个星号一直干掉字符，dp[0][j] = dp[0][j-2] && p[j-1]=*
         * */
        if(s == null && p == null) return true;
        if (p == null && (s != null || s.length() > 0)) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;

        //p不为空串，s为空串，要想匹配只能最右端是星号，这个星号一直干掉字符，dp[0][j] = dp[0][j-2] && p[j-1]=*
        for (int i = 1; i < p.length() + 1; i++) {
            dp[0][i] = dp[0][i-2] && p.charAt(i-1)=='*';
        }

        //从右到左，或者从左到右的分析，是否影响i ，j 对s，p的判定
        // 我们明确的是，dp[0][0],dp[0][0,1,2,3...p] 已经初始化了
        // 如果我们一开始就确定 dp[10][9]，我们需要dp[9][8]等参数的协助，但是这些参数还没有初始化，就需要一点一点的向下寻找初始化，所以
        // i ，j 对s，p的遍历，应该从0开始
        for (int i = 1; i < s.length()+1  ; i++) {
            for (int j = 1; j < p.length()+1 ; j++) {
                //  情况一：如果：s[i-1] == p[j-1] || p[j-1]= '.' 则 dp[i][j] = dp[i-1][j-1]
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
//                    情况二：如果： s[i-1] != p[j-1] , 则不能判断s,p不匹配；dp[i][j]=false，可能是p[j-1]等于* 引起的不匹配
//                    如果p[j-1]等于*,且 s[i-1]和p[j-2]匹配，要考虑三种情况：
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
                        dp[i][j] =   dp[i][j-2]  //如果*表示复制0次，也就 p中的 [j-2,*]不在出现，则需要考察的是s(0,i-1) 和 p(0,j-3) 也就是dp[i][j-2]
                                  || dp[i-1][j-2] // 如果*表示复制1次，也就是 p中的[j-2,*]出现一次,则需要考察的是s(0,i-2) 和 p(0,j-3)也就是dp[i-1][j-2]
                                  || dp[i-1][j]; // 如果*表示复制多次，也就是 p中[j-2,*]*出现多次,那我们就是在p中出现了很多次的j-1,我们拿出了一个j-1和i-1进行抵消
//还有剩下的j-1一样存在，则需要考察的是s(0,i-2) 和 p(0,j-1)也就是dp[i-1][j]
                    } else{
//                        如果p[j-1]等于*,且 s[i-1]和p[j-2]不匹配,就需要把p[j-2,*]直接的消掉，才能继续匹配，不然就要返回false了
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static boolean isMatch_2(String s, String p) {
        if(s == null || p == null) return false;
        //dp[i][j] represent:  s[i] is pattern p[j]
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // init 
        dp[0][0] = true;

        // dp[i][0] is false represent:s="ssdd",p="",so is false;
        //init: dp[0][j]
        for(int j = 1;j< dp[0].length ; j++){
            if(p.charAt(j-1) == '*' && (dp[0][j-1] || j>1 && dp[0][j-2])){
                dp[0][j]=true;
            }
        }

        // initialize dp
        for(int i=1;i<dp.length;i++){
            for (int j = 1; j < dp[0].length; j++) {
                // s[i] == p[j],for example: “aa” == “aa” , so: dp[i][j] = dp[i-1][j-1]
                // p[j] = '.' so: dp[i][j] = dp[i-1][j-1]
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                if(p.charAt(j-1) == '*'){
                    // for example (aa ,a*)  or (aa ,.*)
                    // i j 第几个字符，在dp的数组中指代，所以在s,p的下标就是i-1,j-1

                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-1) == '.' ){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        // dp[i][j-2], a* means ""
                        // dp[i][j-1], a* means "a"
                        // dp[i-1][j], a* means "aa"
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }

                }
            }
        }
        
        

        return dp[s.length()][p.length()];
    }

    /**
     * s 目标字符串
     * p 含有规则的字符串
     * */
    public static boolean isMatch_1(String s, String p) {
        if(s == null || p == null) return false;
        //dp[i][j] represent: from i to j:  s[i] is pattern p[j]
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // init
        dp[0][0] = true;

        // dp[i][0] is false represent:s="ssdd",p="",so is false;
        //init: dp[0][j]
        for(int j = 1;j< dp[0].length ; j++){
            if(p.charAt(j-1) == '*' && (dp[0][j-1] || j>1 && dp[0][j-2])){
                dp[0][j]=true;
            }
        }

        // initialize dp
        for(int i=1;i<dp.length;i++){
            for (int j = 1; j < dp[0].length; j++) {
                // s[i] == p[j],for example: “aa” == “aa” , so: dp[i][j] = dp[i-1][j-1]
                // p[j] = '.' so: dp[i][j] = dp[i-1][j-1]
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                if(p.charAt(j-1) == '*'){
                    // for example (aa ,a*)  or (aa ,.*)
                    // i j 第几个字符，在dp的数组中指代，所以在s,p的下标就是i-1,j-1
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-1) == '.' ){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        // dp[i][j-2], a* means ""
                        // dp[i][j-1], a* means "a"
                        // dp[i-1][j], a* means "aa"
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }

                }
            }
        }
        return dp[s.length()][p.length()];
    }



    public static void main(String[] args) {
        System.out.println("hello holiaday!");
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a."));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", "a*ab"));
        System.out.println(isMatch("aa", "ca*ab"));
    }
}