
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * first: describe the problem
     *      find the longest palindrome subString
     * second: use dp
     *          dp[i][j] from i to j is palindrome String
     *          dp[i][i]=true
     *          dp[i][j]= dp[i-1][j-1] && s[i]=s[j]
     * third: write the code
     * fouth: test the cases
     * */
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=true;
        }
        int max=1,i=0,j=0;
        for (int k = s.length()-1; k >=0 ; k--) {
            for (int l = k+1; l <= s.length()-1 ; l++) {
                // k和L之间的距离来判断 aa 和 aba的情况
                if((l-k == 1 && s.charAt(k) == s.charAt(l))
                        || ((l-k>1) &&  (k+1) < s.length() && (l-1) >= 0 && dp[k+1][l-1] && s.charAt(k) == s.charAt(l))) {
                    dp[k][l] = true;
                    if(l-k+1 > max){
                        i=k;j=l;max=l-k+1;
                        System.out.println(s.substring(i,j+1));
                    }
                }
            }
        }
        return s.substring(i,j+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
