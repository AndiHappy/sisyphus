package l;

import util.PrintUtil;

import java.util.Arrays;

public class LeetCode062_Unique_Paths {

    /**
     *
     62. Unique Paths
     A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

     The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

     How many possible unique paths are there?



     Example 1:


     Input: m = 3, n = 7
     Output: 28
     Example 2:

     Input: m = 3, n = 2
     Output: 3
     Explanation:
     From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     1. Right -> Down -> Down
     2. Down -> Down -> Right
     3. Down -> Right -> Down
     Example 3:

     Input: m = 7, n = 3
     Output: 28
     Example 4:

     Input: m = 3, n = 3
     Output: 6


     Constraints:

     1 <= m, n <= 100
     It's guaranteed that the answer will be less than or equal to 2 * 109.
     *
     * */

    /**
     * from top to botom
     * */
    public static int uniquePaths_TOP_TO_BOTTOM(int m, int n) {
        if(m==1 || n== 1){
            return 1;
        }
        int value = (m-1 >0 ? uniquePaths_TOP_TO_BOTTOM(m-1,n):0)+ (n-1 >0 ? uniquePaths_TOP_TO_BOTTOM(m,n-1):0);
        return value;
    }

    public static int uniquePaths_BOTTOM_TO_TOP(int m, int n) {
        int[][] path = new int[m][n];
        for (int[] p : path) {
            Arrays.fill(p,1);
        }
        PrintUtil.pIntArray(path);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0||j==0) continue;
                path[i][j]= path[i-1][j]+path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }
}
