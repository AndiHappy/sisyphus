package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode048 {

/**

 48. 旋转图像
 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。



 示例 1：


 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[[7,4,1],[8,5,2],[9,6,3]]
 示例 2：


 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


 提示：

 n == matrix.length == matrix[i].length
 1 <= n <= 20
 -1000 <= matrix[i][j] <= 1000


 * */

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);

        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
    }



    /**
     * 原地旋转图像
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ===>
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     *
     * [5,1,9,11],
     * [2,4,8,10],
     * [13,3,6,7],
     * [15,14,12,16]
     *
     * ===>
     * [15,13,2,5],
     * [14,3,4,1],
     * [12,6,8,9],
     * [16,7,10,11]
     * */
    /**
     *  从对角线，开始挪移，四个元素依次的轮转
     * */
    public void rotate_1(int[][] matrix) {
        int abs1 = 0;
        int abs2 = matrix.length - 1;
        while (abs1 <= abs2) {
            int p1 = abs1;
            int p2 = abs2;
            while (p1 != abs2) {
                // 四角轮换
                int temp = matrix[abs1][p1];        //左上
                matrix[abs1][p1] = matrix[p2][abs1];//左上 = 左下
                matrix[p2][abs1] = matrix[abs2][p2];//左下 = 右下
                matrix[abs2][p2] = matrix[p1][abs2];//右下 = 右上
                matrix[p1][abs2] = temp;            //右上 = 左上
                p1 += 1;
                p2 -= 1;
            }
            abs1++ ;
            abs2--;
        }

    }


    //Input: matrix = [
    // [1,2,3],
    // [4,5,6],
    // [7,8,9]]

    // [1,4,7],
    // [2,5,8],
    // [3,6,9]]

    // [7,4,1],
    // [8,5,2],
    // [9,6,3]]


//
// [5,1,9,11],
// [2,4,8,10],
// [13,3,6,7],
// [15,14,12,16]

// [5,2, 13, 15],
// [1,4, 3,  14],
// [9,8 ,6,  12],
// 11,10,7,16]


// [15,13,2,5],
// [14,3,4,1],
// [12,6,8,9],
// [16,7,10,11]]
//

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }

        // change 180
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i>=j) continue;
                swap(matrix,i,j);
            }
        }

        System.out.println("----------------------------");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < matrix.length; i++) {
            int j = 0,k = matrix[0].length-1;
            while(j<k){
                swap(matrix,i,j,k);
                j++;k--;
            }

        }

        System.out.println("----------------------------");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void swap(int[][] matrix, int i, int j, int k) {
        int value = matrix[i][j];
        matrix[i][j] = matrix[i][k];
        matrix[i][k] = value;
    }


    private static void swap(int[][] matrix, int i, int j) {
        int value = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = value;
    }
}
