package l;

import util.PrintUtil;

public class LeetCode064_Minimum_Path_Sum {
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
}
