package l;

import util.PrintUtil;

public class LeetCode073 {


    //Given an m x n matrix. If an element is 0, set its entire row and column to 0.
// Do it in-place.
//
// Follow up:
//
//
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
//
//
//
// Example 1:
//
//
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
//
//
// Example 2:
//
//
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
//
// Related Topics Array
// 👍 3450 👎 367

    /**
     1.A straight forward solution using O(mn) space is probably a bad idea.
     2.A simple improvement uses O(m + n) space, but still not the best solution.
     3.Could you devise a constant space solution?

     首先梳理出来关键点在于：怎么标记以前访问过的元素

     O(mn),声明标记的每一个元素，例如setZeroesO_mn

     O(m+n),声明标记行和列即可，例如setZeroesO_m_Plus_n

     O(1), 需要使用一些技巧，在O(m+n)的基础上

     * */

    public static void setZeros(int[][] matrix){
        boolean isZeroCol = false;
        boolean isZeroRow = false;

        //check the first column
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isZeroCol = true;
                break;
            }
        }
        //check the first row
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isZeroRow = true;
                break;
            }
        }

        //check except the first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }

        //process except the first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
        }

        //handle the first column
        if (isZeroCol) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

        //handle the first row
        if (isZeroRow) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
    }

    public static void setZeroesO_m_Plus_n(int[][] matrix) {
        int m = matrix.length;int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    row[i]=col[j]=true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i]||col[j]){
                    matrix[i][j]=0;
                }
            }
        }

    }

    public static void setZeroesO_mn(int[][] matrix) {
        boolean[][] index = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0 && !index[i][j]){
                    setZeroes(matrix,i,j,index);
                }
            }
        }
    }

    private static void setZeroes(int[][] matrix, int i, int j, boolean[][] index) {
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k]=0;
            index[i][k]=true;
        }
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j]=0;
            index[k][j]=true;
        }
    }

    public void setZeroes(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
        int[][] test = PrintUtil.twoDimensionalArray("[[1,1,1],[1,0,1],[1,1,1]]");
        PrintUtil.pIntArray(test);
//        setZeroesO_mn(test);
        setZeroesO_m_Plus_n(test);
        PrintUtil.pLine();
        PrintUtil.pIntArray(test);

        PrintUtil.pLine();
        test = PrintUtil.twoDimensionalArray("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        PrintUtil.pIntArray(test);
//        setZeroesO_mn(test);
        setZeroesO_m_Plus_n(test);
        PrintUtil.pLine();
        PrintUtil.pIntArray(test);




    }

    class Solution {
        public void setZeroes(int[][] matrix) {
            /**
             mn 的方案是直接再 copy 一份，然后遍历 matrix，设置 copy 那份的
             m+n 的方案是m 行 n 列 进行标记
             常量的方式，
             */

            boolean rowflag = false;
            //判断首行
            for(int i=0;i< matrix[0].length;i++){
                if(matrix[0][i] ==0){
                    rowflag = true;
                    break;
                }
            }
            //判断首列
            boolean cloflag = false;
            for(int i=0;i< matrix.length;i++){
                if(matrix[i][0] == 0){
                    cloflag = true;
                    break;
                }
            }
            // 利用数组的首行和首列来记录 0 值。从数组下标的 A[1][1] 开始遍历，两个布尔值记录首行首列是否需要置0
            for(int i=1;i< matrix.length;i++){
                for(int j=1;j<matrix[0].length;j++){
                    if(matrix[i][j] == 0){
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }
                }
            }

            // 1,0 0,1 设置 0
            for(int i=1;i< matrix[0].length;i++){
                if(matrix[0][i] ==0){
                    for(int j=0;j < matrix.length;j++){
                        matrix[j][i]=0;
                    }
                }
            }

            //  1,0 0,1 设置 0
            for(int i=1;i< matrix.length;i++){
                if(matrix[i][0] ==0){
                    for(int j=0;j < matrix[0].length;j++){
                        matrix[i][j]=0;
                    }
                }
            }

            if(rowflag){
                for(int i=0;i< matrix[0].length;i++){
                    matrix[0][i]=0;
                }
            }

            if(cloflag){
                for(int i=0;i< matrix.length;i++){
                    matrix[i][0]=0;
                }
            }
        }
    }

}
