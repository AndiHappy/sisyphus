package l;

public class LeetCode072 {
    public static void main(String[] args) {
        System.out.println("keep happy");
        System.out.println(minDistance("horse", "ros"));
    }

//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
// You have the following three operations permitted on a word:
//
//
// Insert a character
// Delete a character
// Replace a character
//
//
//
// Example 1:
//
//
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation:
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
//
//
// Example 2:
//
//
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation:
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
//
//
//
// Constraints:
//
//
// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.
//
// Related Topics String Dynamic Programming
// 👍 5632 👎 66


    /**
     Let following be the function definition :-

     f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

     Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.

     f(i, j) = f(i - 1, j - 1)

     Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper

     f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }

     f(i, j - 1) represents insert operation
     f(i - 1, j) represents delete operation
     f(i - 1, j - 1) represents replace operation

     Here, we consider any operation from word1 to word2.
     It means, when we say：

     insert operation,we insert a new character after word1 that matches the jth character of word2.
     So, now have to match i characters of word1 to j - 1 characters of word2.

     delete operation, we delete the ith character of word1.
     So, now hava to match i-1 charactes of word1 to j charactres of word2

     replace operation, we replace the ith character of word1 with the jth character of word2.

     Same goes for other 2 operations as well.

     Note that the problem is symmetric. The insert operation in one direction
     (i.e. from word1 to word2) is same as delete operation in other.
     So, we could choose any direction.

     Above equations become the recursive definitions for DP.

     Base Case:

     f(0, k) = f(k, 0) = k

     Below is the direct bottom-up translation of this recurrent relation.
     It is only important to take care of 0-based index with actual code :-


     * */
    public static int minDistance(String word1, String word2) {
        if(word1.equals(word2)) return 0;
        if(word1.length()==0|| word2.length()==0) return Math.abs(word1.length()-word2.length());
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        // ini 0-based index with actual code
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0]=i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i]=i;
        }

        // dp
        for (int i = 1; i <=word1.length() ; i++) {
            for (int j = 1; j <= word2.length() ; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
