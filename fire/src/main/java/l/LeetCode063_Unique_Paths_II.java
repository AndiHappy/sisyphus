package l;

import util.PrintUtil;

public class LeetCode063_Unique_Paths_II {

    /**
     *
     63. Unique Paths II
     Medium

     2656

     292

     Add to List

     Share
     A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

     The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

     Now consider if some obstacles are added to the grids. How many unique paths would there be?

     An obstacle and space is marked as 1 and 0 respectively in the grid.



     Example 1:


     Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     Output: 2
     Explanation: There is one obstacle in the middle of the 3x3 grid above.
     There are two ways to reach the bottom-right corner:
     1. Right -> Right -> Down -> Down
     2. Down -> Down -> Right -> Right
     Example 2:


     Input: obstacleGrid = [[0,1],[0,0]]
     Output: 1


     Constraints:

     m == obstacleGrid.length
     n == obstacleGrid[i].length
     1 <= m, n <= 100
     obstacleGrid[i][j] is 0 or 1.
     *
     * */

    /**
     m == obstacleGrid.length
     n == obstacleGrid[i].length
     1 <= m, n <= 100
     obstacleGrid[i][j] is 0 or 1.
     * */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null ) return 0;
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];

        paths[0][0] = obstacleGrid[0][0] == 1?0:1;
        if(paths[0][0]==0) return 0;

        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[0].length; j++) {
                if(obstacleGrid[i][j]==1) {
                    paths[i][j]=0;
                }else {
                    if(i>0 && obstacleGrid[i-1][j] != 1){
                        paths[i][j]+=paths[i-1][j];
                    }

                    if(j>0 && obstacleGrid[i][j-1] != 1){
                        paths[i][j]+=paths[i][j-1];
                    }
                }
            }
        }
//        PrintUtil.pIntArray(obstacleGrid);
//        PrintUtil.pLine();
//        PrintUtil.pIntArray(paths);
        return paths[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
        int[][] a = PrintUtil.twoDimensionalArray("[[0,0,0],[0,1,0],[0,0,0]]");
        System.out.println(uniquePathsWithObstacles(a));

        a=PrintUtil.twoDimensionalArray("[[0,1],[0,0]]");
        System.out.println(uniquePathsWithObstacles(a));
    }
}
