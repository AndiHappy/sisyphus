package l;

import util.PrintUtil;

public class LeetCode064 {
    /**
     * 64. Minimum Path Sum
     * Medium
     * <p>
     * 4606
     * <p>
     * 84
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
     * <p>
     * Note: You can only move either down or right at any point in time.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     * Example 2:
     * <p>
     * Input: grid = [[1,2,3],[4,5,6]]
     * Output: 12
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 100
     */

    public static int minPathSum(int[][] grid) {
        int[][] minSum = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j > 0) {
                    minSum[i][j] = grid[i][j] + minSum[i][j - 1];
                } else if (j == 0 && i > 0) {
                    minSum[i][j] = grid[i][j] + minSum[i - 1][j];
                } else if (i > 0 && j > 0) {
                    minSum[i][j] = grid[i][j] + Math.min(minSum[i - 1][j], minSum[i][j - 1]);
                } else {
                    minSum[i][j] = grid[i][j];
                }
            }
        }

        return minSum[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
       int[][] a = PrintUtil.twoDimensionalArray("[[1,3,1],[1,5,1],[4,2,1]]");
        System.out.println(minPathSum(a));

        a = PrintUtil.twoDimensionalArray("[[1,2,3],[4,5,6]]");
        System.out.println(minPathSum(a));
    }
    /**
     *
     64. 最小路径和
     给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

     说明：每次只能向下或者向右移动一步。



     示例 1：


     输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     输出：7
     解释：因为路径 1→3→1→1→1 的总和最小。
     示例 2：

     输入：grid = [[1,2,3],[4,5,6]]
     输出：12


     提示：

     m == grid.length
     n == grid[i].length
     1 <= m, n <= 200
     0 <= grid[i][j] <= 100

     * */

    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] path = new int[grid.length][grid[0].length];
            path[0][0] = grid[0][0];
            for(int i =1;i<grid.length;i++){
                path[i][0] = path[i-1][0]+grid[i][0];
            }

            for(int i =1;i<grid[0].length;i++){
                path[0][i] = path[0][i-1]+grid[0][i];
            }

            for(int i =1;i< grid.length;i++){
                for(int j =1;j < grid[0].length;j++){
                    path[i][j] = grid[i][j] + Math.min(path[i-1][j],path[i][j-1]);
                }
            }

            return path[grid.length-1][grid[0].length-1];

        }
    }
}
