package l;

import util.PrintUtil;

import java.util.Arrays;

public class LeetCode062 {

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

    /**
     62. 不同路径
     一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

     问总共有多少条不同的路径？



     示例 1：


     输入：m = 3, n = 7
     输出：28
     示例 2：

     输入：m = 3, n = 2
     输出：3
     解释：
     从左上角开始，总共有 3 条路径可以到达右下角。
     1. 向右 -> 向下 -> 向下
     2. 向下 -> 向下 -> 向右
     3. 向下 -> 向右 -> 向下
     示例 3：

     输入：m = 7, n = 3
     输出：28
     示例 4：

     输入：m = 3, n = 3
     输出：6


     提示：

     1 <= m, n <= 100
     题目数据保证答案小于等于 2 * 109
     * */

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] paths = new int[m][n];
            paths[0][0]=0;
            for(int i =0;i< m;i++) paths[i][0]=1;
            for(int i=0;i< n;i++) paths[0][i] =1;

            for(int i=1;i< m ; i++){
                for(int j=1;j < n;j++){
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
            return paths[m-1][n-1];
        }
    }
}
